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
from django.http import HttpResponse

# Create your views here.
class CatOrDogView(View):
    
    @csrf_exempt
    def cat_or_dog_prediction(request):
        if request.method == 'POST':
            # try:
            #     uploaded_image = request.FILES['image']  # 이미지 파일은 'image' 필드로 전송되어야 함

            #     # 여기에서 이미지를 분류하고 결과를 prediction_result에 할당
            #     # 예측 결과는 'cat' 또는 'dog'와 같은 문자열이어야 함

            #     return JsonResponse({'result': prediction_result})
            return HttpResponse('Success', status=200)
        else:
            return HttpResponse('Method not allowed', status=405)
        

def predict_cat_or_dog(image):
    # 임의의 예측 결과 생성 (실제 모델을 통해 예측하는 것으로 대체 필요)
    labels = ['고양이', '개']
    prediction = np.random.choice(labels)
    return prediction