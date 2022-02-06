
from flask import Flask, redirect ,render_template,request ,session
app=Flask(__name__)

app.secret_key = 'this my first'
@app.route("/")
def form():
    return render_template("dojo.html")

@app.route("/result", methods=['post'])
def result():
    session['name']=request.form['username']
    session['location']=request.form["location"]
    session['lang']=request.form['fav']
    session['comment']=request.form['comment']
    session['gender']=request.form['option']
    session['choose']=request.form['choose']
    return redirect('/info')

@app.route('/info')
def fr():
    return render_template('show.html',name_from_python=session['name'],location_from_python=session['location'],
    lang_from_python=session['lang'],comment_from_python=session['comment']
    ,gender_from_python=session['gender'],choose_from_python=session['choose'])




if __name__=="__main__":
    app.run(debug=True)