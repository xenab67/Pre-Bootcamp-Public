from flask import Flask
app = Flask(__name__)
@app.route('/')
def hello_world():
    return "Hello World"

@app.route('/dojo')
def dojo():
    return "Dojo"

@app.route('/hi/<name>')
def hi(name):
    return (f"Hi {str(name)}!")

@app.route('/repeat/<num>/<word>')
def repeat(num, word):
    return str(word) * int(num)

@app.errorhandler(404)
def not_found(e):
    return "Sorry! No response. Try again."

if __name__=="__main__":
    app.run(debug=True)