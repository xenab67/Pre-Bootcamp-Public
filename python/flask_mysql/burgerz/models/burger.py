# burgers.py
from flask_app import app
from flask import render_template,redirect,request,session,flash
from flask_app.models.burger import burger

from flask_app.config.mysqlconnection import connectToMySQL
# burger.py
class Burger:
    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.bun = data['bun']
        self.meat = data['meat']
        self.calories = data['calories']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']