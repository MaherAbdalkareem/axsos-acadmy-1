
from django.shortcuts import redirect, render
from django.contrib import messages
import bcrypt
from .models import User

def index(request):
    return render(request,'login_and_registration.html')

def register(request):
    request.session['error']="register"
    errors = User.objects.register_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    else:
        password = request.POST['password']
        pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
        this_user=User.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],
        email=request.POST['email'],password=pw_hash)
        request.session['id']=this_user.id
        messages.success(request, "successfully registered")
        return redirect('/books')

def login(request):
    request.session['error']="login"
    errors = User.objects.login_validator(request.POST)
    this_user=User.objects.filter(email=request.POST['useremail'])
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)           
    if  len(this_user)==0:
        messages.error(request, "invalid user")
        return redirect('/')
    elif not (bcrypt.checkpw(request.POST['userpassword'].encode(), this_user[0].password.encode())):
        messages.error(request, "invalid password")
        return redirect('/')
    else:
        request.session['id']=this_user[0].id
        return redirect('/books')

