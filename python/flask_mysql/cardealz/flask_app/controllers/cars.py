from flask import redirect,render_template,session,request,flash
from flask_app import app
from flask_app.models.car import Car
from flask_app.models.user import User

@app.route('/dashboard')
def dashboard():
    if 'user_id' not in session:
        return redirect('/logout')
    data={
        'id': session['user_id']
    }
    cars=Car.get_all_complete()
    user=User.get_by_id(data)
    return render_template("dashboard.html",cars=cars, user=user)

@app.route('/sell/car')
def sell_car():
    if'user_id' not in session:
        return redirect('/logout')
    data = {
        "id":session['user_id']
    }
    return render_template('newcar.html',user=User.get_by_id(data))

@app.route('/create/car',methods=['POST'])
def create_car():
    if 'user_id' not in session:
        return redirect('/logout')
    if not Car.validate_car(request.form):
        return redirect('/sell/car')
    data = {
        "price": request.form["price"],
        "make": request.form["make"],
        "model": request.form["model"],
        "year": request.form["year"],
        "description": request.form["description"],
        "user_id": session["user_id"]
    }
    Car.save(data)
    return redirect('/dashboard')

@app.route('/edit/car/<int:id>')
def edit_car(id):
    if 'user_id' not in session:
        return redirect('/logout')
    data = {
        "id":id
    }
    user_data = {
        "id":session['user_id']
    }
    return render_template("editcar.html", edit=Car.get_one_complete(data),user=User.get_by_id(user_data))

@app.route('/update/car',methods=['POST'])
def update_car():
    if 'user_id' not in session:
        return redirect('/logout')
    if not Car.validate_car(request.form):
        return redirect('/sell/car')
    data = {
        "price": request.form["price"],
        "model": request.form["model"],
        "make": request.form["make"],
        "year": request.form["year"],
        "description": request.form['description'],
        "id":request.form["id"]
    }
    Car.update(data)
    return redirect('/dashboard')

@app.route('/show/car/<int:id>')
def show_car(id):
    if 'user_id' not in session:
        return redirect('/logout')
    data = {
        "id":id
    }
    user_data = {
        "id":session['user_id']
    }
    return render_template("showcar.html",car=Car.get_one(data),user=User.get_by_id(user_data))

@app.route('/destroy/car/<int:id>')
def destroy_car(id):
    if 'user_id' not in session:
        return redirect('/logout')
    data = {
        "id":id
    }
    Car.destroy(data)
    return redirect('/dashboard')