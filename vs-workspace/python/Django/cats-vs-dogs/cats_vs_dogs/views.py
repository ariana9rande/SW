from django.shortcuts import render
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from django.utils.decorators import method_decorator
from django.views import View
from django.core.exceptions import ValidationError
from django.core.validators import URLValidator
import numpy as np
import json
from django.http import JsonResponse
from django.middleware.csrf import get_token

# Create your views here.

def catordog(request):
    # 예측 로직을 수행하고 결과를 얻습니다.
    prediction_result = predict_cat_or_dog(request.FILES['image'])  # 예측 로직을 호출하는 함수로 바꿔야 합니다.

    # 예측 결과에 따라 적절한 응답을 생성합니다.
    if prediction_result == 'cat':
        response_data = {'result': 'It is a cat!'}
    elif prediction_result == 'dog':
        response_data = {'result': 'It is a dog!'}
    else:
        response_data = {'result': 'Unable to determine.'}

    # JsonResponse를 사용하여 JSON 형식의 응답을 반환합니다.
    return JsonResponse(response_data)
        

def predict_cat_or_dog(image):
    # 임의의 예측 결과 생성 (실제 모델을 통해 예측하는 것으로 대체 필요)
    labels = ['고양이', '개']
    prediction = np.random.choice(labels)
    return prediction

def get_csrf_token(request):
    csrf_token = get_token(request)
    return JsonResponse({'csrf_token': csrf_token})