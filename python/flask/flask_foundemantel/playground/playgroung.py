from distutils.log import debug
from flask import Flask ,render_template

app=Flask(__name__)

@app.route('/play')
def playground():
    return render_template('playground.html')


@app.route('/play/<num>')
def numbox(num):
    return render_template('playground2.html',x=int(num))

@app.route('/play/<num>/<color>')
def color(num,color):
    return render_template('playground3.html',x=int(num),color=color)

if __name__=="__main__":
    app.run(debug=True)
