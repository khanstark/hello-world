# -*- coding: utf-8 -*-
# Generated by Django 1.11.18 on 2019-01-14 11:21
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('biom', '0007_auto_20190114_1108'),
    ]

    operations = [
        migrations.RenameField(
            model_name='sample',
            old_name='email',
            new_name='passkey',
        ),
    ]
