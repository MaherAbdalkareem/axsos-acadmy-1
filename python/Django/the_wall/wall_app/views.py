
from xml.etree.ElementTree import Comment
from django.shortcuts import redirect, render
from django.contrib import messages
import bcrypt
from .models import Comments, Post, User

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
        return redirect('/wall')

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
        return redirect('/wall')

def wall(request):
    this_user=User.objects.get(id= request.session['id'])
    post=Post.objects.all().order_by("-created_at")
    comment=Comments.objects.all().order_by("-created_at")
    context={
        'this_user':this_user,
        'post':post,
        'comment':comment
    }
    return render(request,'wall.html',context)

def add_post(request):
    this_post=Post.objects.create(message=request.POST['post'],user=User.objects.get(id= request.session['id']))
    return redirect('/wall')

def add_comment(request):
    this_comment=Comments.objects.create(comment=request.POST['comment'],
    user=User.objects.get(id= request.session['id']),post=Post.objects.get(id= request.POST['post_id']))
    return redirect('/wall')

def delete(request):
    c=Post.objects.get(id=request.POST['delete'])
    c.delete()
    return redirect('/wall')