# Generated by Django 2.2.4 on 2022-02-19 18:25

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('login', '0002_user_birthday'),
    ]

    operations = [
        migrations.CreateModel(
            name='Book',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.CharField(max_length=255)),
                ('desc', models.TextField()),
                ('created_at', models.DateTimeField(auto_now_add=True)),
                ('updated_at', models.DateTimeField(auto_now=True)),
                ('liked_books', models.ManyToManyField(related_name='liked_books', to='login.User')),
                ('uploaded_by', models.ForeignKey(on_delete='cascade', related_name='books_uploaded', to='login.User')),
            ],
        ),
    ]