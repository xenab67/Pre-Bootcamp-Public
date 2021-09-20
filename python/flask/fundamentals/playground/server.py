from flask import Flask, render_template
app = Flask(__name__)

@app.route('/play')
def play():
    return render_template('index.html')

@app.route('/play/<num>')
def playmore(num):
    return render_template('playgroundlev2', times=int(num))

@app.route('/play/<num>/<color>')
def colorblocks(num, color):
    return render_template('playgroundlev3.html', times=int(num), color=color)

if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True) 