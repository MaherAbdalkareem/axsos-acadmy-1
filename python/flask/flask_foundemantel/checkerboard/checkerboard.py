from flask import Flask,render_template
app= Flask(__name__)

@app.route('/')
def box():
    return render_template("cheacker.html")

@app.route('/<num>/<number>')
def table(num,number):
    y=int(number)/2
    t=int(num)/2
    return render_template("checker.html",x=int(t),z=int(y))

@app.route('/<num>/<number>/<color_1>/<color_2>')
def color(num,number,color_1,color_2):
    y=int(number)/2
    t=int(num)/2
    return render_template("cheacker3.html",x=int(t),z=int(y),color1=color_1,color2=color_2)


if __name__=="__main__":
    app.run(debug=True)
