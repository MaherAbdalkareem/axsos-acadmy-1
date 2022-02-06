

from flask import Flask, redirect, request , session,render_template
app=Flask(__name__)
app.secret_key = 'this my first'


@app.route('/')
def count():
    if not 'coun' in session:
        session['coun']=0
    else:
        session['coun']+=1
    return render_template('count.html',number_of_visit=session['coun'])

@app.route('/destroy_session')
def clear():
    session.clear()
    return redirect('/')

@app.route('/increment', methods=['post'] )
def add():
    session['coun']+=1
    return redirect('/')

@app.route('/decrement', methods=['post'] )
def cl():
    session.clear()
    return redirect('/')

@app.route('/increase', methods=['post'])
def plus():
    session['num']=int(request.form['num'])
    session['coun']=session['num']+session['coun']-1
    return redirect('/')


if __name__=="__main__":
    app.run(debug=True)