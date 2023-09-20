from django.urls import path
from . import views

app_name = "cats_vs_dogs"

urlpatterns = [
    path('predict/', views.CatOrDogView.as_view(), name='catordog'),
]