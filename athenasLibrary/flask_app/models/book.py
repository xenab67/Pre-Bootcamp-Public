
from flask import flash
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import user
from flask_app.models.user import User

class Book:
    db_name='book_schema'
    def __init__(self,data):
        self.id= data['id']
        self.title= data['title']
        self.author= data['author']
        self.description = data['description']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.poster = None
        self.likers=[]

    @classmethod
    def get_all(cls):
        query="SELECT * FROM books;"
        results = connectToMySQL(cls.db_name).query_db(query)
        new_books = []
        for book in results:
            new_books.append(cls(book))
        return new_books

    @classmethod
    def love_book(cls,data):
        query="INSERT INTO likes(book_id,user_id) VALUES(%(book_id)s,%(user_id)s);"
        return connectToMySQL(cls.db_name).query_db(query,data)

    @classmethod
    def hate_book(cls,data):
        query="DELETE FROM likes WHERE book_id=%(book_id)s AND user_id=%(user_id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)

    @classmethod
    def get_by_id(cls,data):
        query = "SELECT * FROM books WHERE books.id = %(id)s;"
        results = connectToMySQL(cls.db_name).query_db(query,data)
        book = cls(results[0])
        return book

    @classmethod
    def get_one_complete(cls,data):
        query="SELECT * FROM books JOIN users ON books.user_id = users.id WHERE books.id = %(id)s;"
        results= connectToMySQL(cls.db_name).query_db(query, data)
        book =cls(results[0])
        user_data = {
                    'id' :results[0]['users.id'],
                    'first_name': results[0]['first_name'],
                    'last_name' : results[0]['last_name'],
                    'email' : results[0]['email'],
                    'password': results[0]['password'],
                    'created_at': results[0]['users.created_at'],
                    'updated_at': results[0]['users.updated_at'],
                }
        poster = user.User(user_data)
        book.poster = poster
        return book

    @classmethod
    def get_one_final(cls):
        query="SELECT * FROM books JOIN users  ON users.id=books.user_id LEFT JOIN likes ON books.id=likes.book_id LEFT JOIN users AS likers ON likes.user_id=likers.id;"
        results=connectToMySQL(cls.db_name).query_db(query)
        all_books = []
        for result in results:
            new_book = True
            liker_data={
                'id': result['likers.id'],
                'first_name': result['likers.first_name'],
                'last_name': result['likers.last_name'],
                'email': result['likers.email'],
                'password': result['likers.password'],
                'created_at': result['likers.created_at'],
                'updated_at': result['likers.updated_at'],
            }
            if len(all_books) >0 and all_books[len(all_books)-1].id == result['id']:
                all_books[len(all_books)-1].likers.append(User(liker_data))
                new_book=False

            if new_book:
                book=cls(result)
                poster_data={
                    'id': result['users.id'],
                    'first_name': result['first_name'],
                    'last_name':result['last_name'],
                    'email': result['email'],
                    'password': result['password'],
                    'created_at': result['users.created_at'],
                    'updated_at': result['users.updated_at'],
                }
                poster= user.User(poster_data)
                book.poster=poster

                if result['likers.id'] is not None:
                    book.likers.append(User(liker_data))
                all_books.append(book)
        return all_books


    @classmethod
    def get_all_complete(cls):
        query="SELECT * FROM books JOIN users ON books.user_id=users.id;"
        results = connectToMySQL(cls.db_name).query_db(query)
        new_books = []
        if len(results) == 0:
            return new_books
        else:
            for book in results:
                user_data = {
                    'id' :book['users.id'],
                    'first_name': book['first_name'],
                    'last_name' : book['last_name'],
                    'email' : book['email'],
                    'password': book['password'],
                    'created_at': book['users.created_at'],
                    'updated_at': book['users.updated_at'],
                }
                poster = user.User(user_data)
                new_book = cls(book)
                new_book.poster = poster
                new_books.append(new_book)
            return new_books

    @classmethod
    def save(cls,data):
        query="INSERT INTO books (title, author, description, user_id) VALUES (%(title)s,%(author)s,%(description)s, %(user_id)s);"
        data = {
            'title': data['title'],
            'author':data['author'],
            'description':data['description'],
            'user_id':data['user_id']
        }
        return connectToMySQL(cls.db_name).query_db(query,data)

    @classmethod
    def update(cls, data):
        query= "UPDATE books SET title = %(title)s, author= %(author)s,description = %(description)s WHERE books.id=%(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)

    # @classmethod
    # def get_my_books(cls,data):
    #     query="SELECT * FROM books WHERE user_id=%(user_id)s"
    #     books = connectToMySQL(cls.db_name).query_db(query,data)
    #     results=[]
    #     for book in books:
    #         results.append(cls(book))
    #     return results

    @classmethod
    def get_loved_books(cls,data):
        loved_books=[]
        query="SELECT book_id FROM likes JOIN users ON users.id=user_id WHERE user_id=%(id)s;"
        results= connectToMySQL(cls.db_name).query_db(query,data)
        for result in results:
            loved_books.append(result['book_id'])
        return loved_books


    @classmethod
    def destroy(cls,data):
        query = "DELETE FROM books WHERE id = %(id)s;"
        return connectToMySQL(cls.db_name).query_db(query,data)

    @staticmethod
    def is_valid(data):
        is_valid= True
        if len(data['title']) < 1:
            flash("Title required", "book")
            is_valid = False
        if len(data['author']) < 1:
            flash("Author is required", "book")
            is_valid = False
        if len(data['description']) < 5:
            flash("Description must be at least 15 characters", "book")
            is_valid= False
        return is_valid