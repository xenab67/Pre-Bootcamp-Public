from flask_app.config.mysqlconnection import connectToMySQL
import re
from flask import flash

from flask_app.models import band

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class User:
    db_name ="bands"
    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.bands=[]

    @classmethod
    def save(cls,data):
        query ="INSERT INTO users (first_name,last_name,email,password) VALUES(%(first_name)s,%(last_name)s,%(email)s,%(password)s);"
        return connectToMySQL(cls.db_name).query_db(query,data)

    @classmethod
    def get_all(cls):
        query ="SELECT * FROM users"
        results = connectToMySQL(cls.db_name).query_db(query)
        users=[]
        for row in results:
            users.append( cls(row))
        return users

    @classmethod
    def get_by_email(cls,data):
        query = "SELECT * FROM users WHERE email = %(email)s;"
        results = connectToMySQL(cls.db_name).query_db(query,data)
        if len(results) < 1:
            return False
        return cls(results[0])

    @classmethod
    def get_by_id(cls,data):
        query = "SELECT * FROM users WHERE id = %(id)s;"
        results = connectToMySQL(cls.db_name).query_db(query,data)
        return cls(results[0])

    @classmethod
    def get_my_bands(cls,data):
        query="SELECT * FROM users LEFT JOIN bands on bands.user_id=users.id WHERE users.id = %(id)s;"
        results = connectToMySQL(cls.db_name).query_db(query,data)
        user = (cls(results[0]))
        if results[0]['bands.id'] == None:
                return (cls(results[0]))
        else:
                for band_dict in results:
                    band_data = {
                        "id" : band_dict['bands.id'],
                        "name": band_dict['name'],
                        "genre": band_dict['genre'],
                        "hometown" :band_dict['hometown'],
                        "user_id" : band_dict['user_id'],
                        "created_at" :band_dict['bands.created_at'],
                        "updated_at": band_dict['bands.updated_at']
                }
                user.bands.append(band.Band.get_my_bands(band_data))
        return user



    @staticmethod
    def validate_register(user):
        is_valid = True
        query = "SELECT * FROM users WHERE email = %(email)s;"
        results = connectToMySQL(User.db_name).query_db(query,user)
        if len(results) >= 1:
            flash("Email already taken.","register")
            is_valid=False
        if not EMAIL_REGEX.match(user['email']):
            flash("Invalid Email!!!","register")
            is_valid=False
        if len(user['first_name']) < 2:
            flash("First name must be at least 2 characters","register")
            is_valid= False
        if len(user['last_name']) < 2:
            flash("Last name must be at least 2 characters","register")
            is_valid= False
        if len(user['password']) < 8:
            flash("Password must be at least 8 characters","register")
            is_valid= False
        if user['password'] != user['confirm']:
            flash("Passwords don't match","register")
            is_valid=False
        return is_valid