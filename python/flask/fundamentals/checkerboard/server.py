from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def eightcheck():
    return render_template('index.html')

@app.route('/<num2>')
def fourcheck(num2):
    return render_template('checkfour.html',num2=int(num2))

@app.route('/<num1>/<num2>')
def checkboard(num1, num2):
    return render_template('checkboard.html', num1=int(num1), num2=int(num2))


if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True) 