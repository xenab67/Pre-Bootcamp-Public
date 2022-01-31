from flask_app.models import book
from flask_app.models import user
from flask import render_template, session, redirect, request, flash
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import app
from flask_app.models.book import Book
from flask_app.models.user import User

@app.route('/dashboard')
def dashboard():
    if 'user_id' in session:
        flash('Please login or register to view this page! :)')
        redirect('/')
    data={
        'id': session['user_id']
    }
    books=Book.get_one_final()
    user=User.get_by_id(data)
    loved_books = Book.get_loved_books(data)
    return render_template("dashboard.html", books=books, user=user, loved_books=loved_books)

@app.route('/edit/book/<int:id>')
def edit_book(id):
    if 'user_id' not in session:
        return redirect('/logout')
    data = {
        "id":id
    }
    user_data = {
        "id":session['user_id']
    }
    return render_template("editbook.html", edit=Book.get_one_complete(data),user=User.get_by_id(user_data))

@app.route('/books/update', methods=['POST'])
def update_book():
    if not 'user_id' in session:
        return redirect('/')
    if not Book.is_valid(request.form):
        return redirect('/books/new')
    data={
        'id': request.form['id'],
        'title': request.form['title'],
        'author': request.form['author'],
        'description': request.form['description'],
    }
    Book.update(data)
    return redirect('/dashboard')

@app.route('/books/new')
def add_book():
    if'user_id' not in session:
        return redirect('/logout')
    data = {
        "id":session['user_id']
    }
    return render_template('newbook.html',user=User.get_by_id(data))

@app.route('/new/book', methods=['POST'])
def new_book():
    if not 'user_id' in session:
        flash('Please login or register to view this page! :)')
        redirect('/')
    if not Book.is_valid(request.form):
        return redirect('/books/new')
    data={
        'title':request.form['title'],
        'author':request.form['author'],
        'description':request.form['description'],
        'user_id':session['user_id']
    }
    Book.save(data)
    return redirect('/dashboard')
    
@app.route('/book/<int:book_id>')
def show_book(book_id):
    if not 'user_id' in session:
        flash('Please login or register to view this page! :)')
        redirect('/')
    data={
        'id': session['user_id']
    }
    user=User.get_by_id(data)
    data={
        'id': book_id
    }
    book =Book.get_one_complete(data)
    return render_template("showbook.html", user=user, book=book)

@app.route('/books/love/<int:book_id>')
def love(book_id):
    data={
        "book_id": book_id,
        "user_id": session['user_id'],
    }
    Book.love_book(data)
    return redirect('/dashboard')

@app.route('/books/unheart/<int:book_id>')
def unheart(book_id):
    data={
        "book_id": book_id,
        "user_id": session['user_id'],
    }
    Book.hate_book(data)
    return redirect('/dashboard')

# @app.route('/user/<int:id>')
# def my_books(id):
#     if not 'user_id' in session:
#         flash('Please login or register to view this page! :)')
#         redirect('/')
#     user_data={
#         'id': id
#     }
#     user=User.get_by_id(user_data)
#     data={
#         "user_id": session['user_id']
#     }
#     my_books=Book.get_my_books(data)
#     return render_template("mybooks.html", user=user,my_books=my_books)

@app.route('/destroy/book/<int:id>')
def destroy_book(id):
    if 'user_id' not in session:
        return redirect('/logout')
    data = {
        "id":id,
    }
    Book.destroy(data)
    return redirect('/dashboard')