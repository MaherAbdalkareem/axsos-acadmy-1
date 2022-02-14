from datetime import datetime
from django.db import models

class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['title'])<2:
            errors["title"] = "Show title should be at least 2 characters"
        if len(postData['network'])<3:
            errors["network"] = "Show network should be at least 3 characters"
        if 0<len(postData['description'])<10:
            errors["description"] = "Show description should be at least 10 characters"
        if postData['release_date']>str(datetime.now()):
            errors["release_date"] = "Show release_date should be in the past"
        return errors

class Show(models.Model):
    title=models.CharField(max_length=255)
    network=models.CharField(max_length=255)
    release_date=models.DateField()
    description=models.TextField()
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    objects = ShowManager()

