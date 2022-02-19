
from datetime import datetime
from multiprocessing import Manager
from django.db import models
import re

class UserManager(models.Manager):
    def register_validator(self,postData):
        errors={}
        if len(postData['first_name']) < 2:
            errors["first_name"] = "Fisrt name should be at least 2 characters"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "last name should be at least 2 characters"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):              
            errors['email'] = "Invalid email address!"
        this_user=User.objects.filter(email=postData['email'])
        if this_user:
            errors['exsistance']="this email already exisit"
        if postData['birthday']> str(datetime.now()):
            errors["birthday"] = "birthday should be in the past"
        if len(postData['password']) < 8:
            errors["password"] = "your password should be more then 8 character"
        if postData['password'] != postData['confirm']:
            errors['confirm']="the confirm password doesn't match the password"
        return errors

    def login_validator(self,postData):
        errors={}
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['useremail']):              
            errors['useremail'] = "Invalid email address!"
        if len(postData['userpassword']) < 8 :
            errors['userpassword']="your password should be more then 8 character"
        return errors




class User(models.Model):
    first_name=models.CharField(max_length=255)
    last_name=models.CharField(max_length=255)
    email=models.CharField(max_length=255)
    password=models.CharField(max_length=255)
    birthday=models.DateField(null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects=UserManager()

class Post(models.Model):
    message=models.TextField()
    user=models.ForeignKey(User,related_name="posts",on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Comments(models.Model):
    comment=models.TextField()
    user=models.ForeignKey(User,related_name="comments",on_delete=models.CASCADE)
    post=models.ForeignKey(Post,related_name="comments",on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)