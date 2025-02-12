"""
Django settings for BusinessContact project.

Generated by 'django-admin startproject' using Django 1.11.7.

For more information on this file, see
https://docs.djangoproject.com/en/1.11/topics/settings/

For the full list of settings and their values, see
https://docs.djangoproject.com/en/1.11/ref/settings/
"""

import os

# Build paths inside the project like this: os.path.join(BASE_DIR, ...)
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


# Quick-start development settings - unsuitable for production
# See https://docs.djangoproject.com/en/1.11/howto/deployment/checklist/

# SECURITY WARNING: keep the secret key used in production secret!
SECRET_KEY = 't#bxfu5e7&@&pt&-20gt3x84o=hbquwrh7)ti%ss+@)f6q+k8&'

# SECURITY WARNING: don't run with debug turned on in production!
DEBUG = True

ALLOWED_HOSTS = []


# Application definition

INSTALLED_APPS = [
    'polls.apps.PollsConfig',
    'hotel.apps.HotelConfig',
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
]

MIDDLEWARE = [
    'django.middleware.security.SecurityMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.common.CommonMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
    'django.middleware.clickjacking.XFrameOptionsMiddleware',
]

ROOT_URLCONF = 'BusinessContact.urls'

TEMPLATES = [
    {
        'BACKEND': 'django.template.backends.django.DjangoTemplates',
        'DIRS': [],
        'APP_DIRS': True,
        'OPTIONS': {
            'context_processors': [
                'django.template.context_processors.debug',
                'django.template.context_processors.request',
                'django.contrib.auth.context_processors.auth',
                'django.contrib.messages.context_processors.messages',
            ],
        },
    },
]

WSGI_APPLICATION = 'BusinessContact.wsgi.application'


# Database
# https://docs.djangoproject.com/en/1.11/ref/settings/#databases

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.mysql',
        'NAME': 'Assignment3',
        'USER': 'root',
        'PASSWORD': 'csc423',
        'HOST': '35.185.7.33',
        'PORT': '3306',
    },

    'polls_db': {
        'ENGINE': 'django.db.backends.mysql',
        'NAME': 'polls_db',
        'USER': 'root',
        'PASSWORD': 'csc423',
        'HOST': '35.185.7.33',
        'PORT': '3306',
    },

    'hotel_db': {
    'ENGINE': 'django.db.backends.mysql',
    'NAME': 'hotel_db',
    'USER': 'root',
    'PASSWORD': 'csc423',
    'HOST': '35.185.7.33',
    'PORT': '3306',
    },
}

DATABASE_ROUTERS = ['hotel.dbRouter.HotelDBRouter', 'polls.dbRouter.PollsDBRouter']

# Password validation
# https://docs.djangoproject.com/en/1.11/ref/settings/#auth-password-validators

AUTH_PASSWORD_VALIDATORS = [
    {
        'NAME': 'django.contrib.auth.password_validation.UserAttributeSimilarityValidator',
    },
    {
        'NAME': 'django.contrib.auth.password_validation.MinimumLengthValidator',
    },
    {
        'NAME': 'django.contrib.auth.password_validation.CommonPasswordValidator',
    },
    {
        'NAME': 'django.contrib.auth.password_validation.NumericPasswordValidator',
    },
]


# Internationalization
# https://docs.djangoproject.com/en/1.11/topics/i18n/

LANGUAGE_CODE = 'en-us'

TIME_ZONE = 'UTC'

USE_I18N = True

USE_L10N = True

USE_TZ = True


# Static files (CSS, JavaScript, Images)
# https://docs.djangoproject.com/en/1.11/howto/static-files/

STATIC_URL = '/static/'









============================
=
=
=
=
=
============================












# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.

class Booking(models.Model):
    bookingid = models.AutoField(db_column='bookingId', primary_key=True)  # Field name made lowercase.
    hotelno = models.ForeignKey('Hotel', models.DO_NOTHING, db_column='hotelNo')  # Field name made lowercase.
    guestno = models.ForeignKey('Guest', models.DO_NOTHING, db_column='guestNo')  # Field name made lowercase.
    datefrom = models.DateTimeField(db_column='dateFrom')  # Field name made lowercase.
    dateto = models.DateTimeField(db_column='dateTo', blank=True, null=True)  # Field name made lowercase.
    roomno = models.ForeignKey('Room', models.DO_NOTHING, db_column='roomNo')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'Booking'

class Guest(models.Model):
    guestno = models.AutoField(db_column='guestNo', primary_key=True)  # Field name made lowercase.
    guestname = models.CharField(db_column='guestName', max_length=255)  # Field name made lowercase.
    guestaddress = models.CharField(db_column='guestAddress', max_length=255, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'Guest'


class Hotel(models.Model):
    hotelno = models.AutoField(db_column='hotelNo', primary_key=True)  # Field name made lowercase.
    hotelname = models.CharField(db_column='hotelName', max_length=255, blank=True, null=True)  # Field name made lowercase.
    city = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Hotel'


class Room(models.Model):
    roomno = models.IntegerField(db_column='roomNo', primary_key=True)  # Field name made lowercase.
    hotelno = models.ForeignKey(Hotel, models.DO_NOTHING, db_column='hotelNo')  # Field name made lowercase.
    type = models.CharField(max_length=255, blank=True, null=True)
    price = models.IntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Room'
        unique_together = (('roomno', 'hotelno'),)









