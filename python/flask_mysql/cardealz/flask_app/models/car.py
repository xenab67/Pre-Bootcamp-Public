from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app.models import user

class Car:
    db_name='car_sales'

    def __init__(self,db_data):
        self.id=db_data['id']
        self.price=db_data['price']
        self.make=db_data['make']
        self.model=db_data['model']
        self.year=db_data['year']
        self.description=db_data['description']
        self.user_id=db_data['user_id']
        self.created_at=db_data['created_at']
        self.updated_at=db_data['updated_at']
        self.poster = None

    @classmethod
    def save(cls,data):
        query = "INSERT INTO cars (price, make, model,year,description, user_id,created_at,updated_at) VALUES (%(price)s,%(make)s,%(model)s,%(year)s,%(description)s,%(user_id)s, NOW(), NOW());"
        data = {
            'price': data['price'],
            'make':data['make'],
            'model':data['model'],
            'year':data['year'],
            'description':data['description'],
            'user_id':data['user_id']
        }
        return connectToMySQL(cls.db_name).query_db(query,data)


    @classmethod
    def get_one(cls,data):
        query = "SELECT * FROM cars WHERE id = %(id)s;"
        results = connectToMySQL(cls.db_name).query_db(query,data)
        return cls( results[0] )
    
    @classmethod
    def get_one_complete(cls,data):
        query = "SELECT * FROM cars LEFT JOIN users on cars.user_id = users.id WHERE cars.id=%(id)s; "
        results = connectToMySQL(cls.db_name).query_db(query,data)
        car=cls(results[0])
        user_data={
            "id": results[0]['users.id'],
            "first_name":results[0]['first_name'],
            "last_name":results[0]['last_name'],
            "email":results[0]['email'],
            "password":results[0]['password'],
            "created_at":results[0]['users.created_at'],
            "updated_at":results[0]['users.updated_at'],
        }
        car.poster=user.User(user_data)
        return car

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM cars"
        results= connectToMySQL(cls.db_name).query_db(query)
        all_cars = []
        if len(results) ==0:
            return False
        for car in results:
            all_cars.append(cls(car))
        return all_cars

    @classmethod
    def get_all_complete(cls):
        query = "SELECT * FROM cars LEFT JOIN users on cars.user_id = users.id; "
        results= connectToMySQL(cls.db_name).query_db(query)
        all_cars = []
        if len(results) ==0:
            return all_cars
        else:
            for car in results:
                print(car)
                user_data={
                    "id": car['users.id'],
                    "first_name":car['first_name'],
                    "last_name":car['last_name'],
                    "email":car['email'],
                    "password":car['password'],
                    "created_at":car['users.created_at'],
                    "updated_at":car['users.updated_at'],
                }
                a_car=cls(car)
                a_car.poster=user.User(user_data)
                all_cars.append(a_car)
            return all_cars

    @classmethod
    def update(cls, data):
        query = "UPDATE cars SET price=%(price)s, make=%(make)s, model=%(model)s, year=%(year)s, description=%(description)s,updated_at=NOW() WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)
    
    @classmethod
    def destroy(cls,data):
        query = "DELETE FROM cars WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)

    @staticmethod
    def validate_car(car):
        is_valid = True
        if car['price'] =="":
            is_valid = False
            flash("Price must be more than $0.","car")
        if len(car['make']) < 2:
            is_valid = False
            flash("Make must be at least 2 characters","car")
        if len(car['model']) < 2:
            is_valid = False
            flash("Model must be at least 2 characters","car")
        if car['year']=="":
            is_valid=False
            flash("Year must be greater than 0.","car")
        if len(car['description']) <15:
            is_valid = False
            flash("Description must be at least 15 characters.", "car")
        return is_valid