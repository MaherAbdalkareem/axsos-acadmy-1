from flask import Flask  
app = Flask(__name__)    
@app.route('/')          
def hello_world():
    return 'Hello World!'  

@app.route('/dojo')          
def dojo():
    return 'DOJO' 


@app.route('/say/<name>')          
def sy(name):
    return f'Hello {name}' 


@app.route('/repate/<num>/<name>')          
def repate(num,name):
    return f'Hello {name}'*int(num)  


if __name__=="__main__":       
    app.run(debug=True)    
