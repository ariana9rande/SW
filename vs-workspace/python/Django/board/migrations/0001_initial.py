# Generated by Django 4.1 on 2023-09-20 00:43

from django.db import migrations, models
import django.utils.timezone


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Notice',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.CharField(max_length=100)),
                ('content', models.CharField(max_length=2000)),
                ('write_date', models.DateTimeField(default=django.utils.timezone.now, editable=False)),
                ('write_id', models.CharField(max_length=50)),
            ],
        ),
    ]