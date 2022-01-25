from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app.models import user

class Band:
    db_name = 'bands'

    def __init__(self,db_data):
        self.id = db_data['id']
        self.name = db_data['name']
        self.genre = db_data['genre']
        self.member = db_data['member']
        self.hometown = db_data['hometown']
        self.user_id = db_data['user_id']
        self.created_at = db_data['created_at']
        self.updated_at = db_data['updated_at']
        self.creator = None

    @classmethod
    def save(cls,data):
        query = "INSERT INTO bands (name, genre, hometown, user_id) VALUES (%(name)s,%(genre)s,%(hometown)s,%(user_id)s);"
        return connectToMySQL(cls.db_name).query_db(query, data)

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM bands"
        results =  connectToMySQL(cls.db_name).query_db(query)
        all_bands = []
        if len(results) ==0:
            return all_bands
        else:
            for row in results:
                all_bands.append( cls(row) )
            return all_bands

    @classmethod
    def get_all_complete(cls):
        query = "SELECT * FROM bands JOIN users on bands.user_id = users.id;"
        results =  connectToMySQL(cls.db_name).query_db(query)
        all_bands = []
        if len(results) == 0:
            return all_bands
        else:
            for row in results:
                print(row)
                a_band=cls(row)
                user_data ={
                "id": row['users.id'],
                "first_name":row['first_name'],
                "last_name":row['last_name'],
                "email":row['email'],
                "password":row['password'],
                "created_at" :row['users.created_at'],
                "updated_at":row['users.updated_at'],
                }
                a_band.creator=user.User(user_data)
                all_bands.append(a_band)
            return all_bands

    
    @classmethod
    def get_one(cls,data):
        query = "SELECT * FROM bands WHERE id = %(id)s;"
        results = connectToMySQL(cls.db_name).query_db(query,data)
        return cls( results[0] )


    @classmethod
    def update(cls, data):
        query = "UPDATE bands SET name=%(name)s, genre=%(genre)s, hometown=%(hometown)s,updated_at=NOW() WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)

    @classmethod
    def destroy(cls,data):
        query = "DELETE FROM bands WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)

    @classmethod
    def get_my_bands(cls,data):
        query= "SELECT * FROM bands JOIN users ON bands.user_id=users.id WHERE users.id=%(id)s;"
        results = connectToMySQL(cls.db_name).query_db(query,data)
        if not results:
            return False
        band = (cls(results[0]))
        users_data = {
            "id": results[0]['users.id'],
            "first_name":results[0]['first_name'],
            "last_name":results[0]['last_name'],
            "email":results[0]['email'],
            "password":results[0]['password'],
            "created_at" :results[0]['users.created_at'],
            "updated_at":results[0]['users.updated_at'],
        }
        band.user= user.User(users_data)
        return band

    @staticmethod
    def validate_band(band):
        is_valid = True
        if len(band['name']) < 2:
            is_valid = False
            flash("Name must be at least 2 characters","band")
        if len(band['genre']) < 2:
            is_valid = False
            flash("Genre must be at least 2 characters","band")
        if len(band['hometown']) < 3:
            is_valid = False
            flash("Hometown must be at least 3 characters","band")
        return is_valid

    