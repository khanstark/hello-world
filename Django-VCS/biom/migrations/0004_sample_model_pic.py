# -*- coding: utf-8 -*-
# Generated by Django 1.11.18 on 2019-01-14 10:52
from __future__ import unicode_literals

from django.db import migrations, models
import django.utils.timezone


class Migration(migrations.Migration):

    dependencies = [
        ('biom', '0003_auto_20190114_1031'),
    ]

    operations = [
        migrations.AddField(
            model_name='sample',
            name='model_pic',
            field=models.ImageField(default=django.utils.timezone.now, upload_to=b''),
            preserve_default=False,
        ),
    ]