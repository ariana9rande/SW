from django.http import JsonResponse
from rest_framework.decorators import api_view
from rest_framework.parsers import FileUploadParser
from .predict import predict_cat_or_dog  # 모델 예측 로직을 포함하는 모듈을 가져와야 합니다.
import numpy as np
from tensorflow.keras.models import load_model
from tensorflow.keras.preprocessing import image

# 미리 학습된 모델을 로드합니다.
MODEL = load_model('/path/to/your/model/dogs-vs-cats.hdf5')

@api_view(['POST'])
def predict_cat_or_dog_view(request):
    # 업로드된 이미지를 받기 위해 FileUploadParser 사용
    parser = FileUploadParser()
    image = request.data.get('image')
    
    if image:
        # 이미지를 모델로 전달하여 예측 수행
        prediction_result = predict_cat_or_dog(image)

        # 예측 결과에 따라 적절한 응답을 생성합니다.
        if prediction_result == 'cat':
            response_data = {'result': 'It is a cat!'}
        elif prediction_result == 'dog':
            response_data = {'result': 'It is a dog!'}
        else:
            response_data = {'result': 'Unable to determine.'}

        # JsonResponse를 사용하여 JSON 형식의 응답을 반환합니다.
        return JsonResponse(response_data)
    else:
        return JsonResponse({'result': 'No image provided.'}, status=400)
    
def predict_cat_or_dog(image):
    # 이미지를 모델에 맞는 형식으로 전처리합니다.
    img = image.load_img(image, target_size=(224, 224))
    img = image.img_to_array(img)
    img = np.expand_dims(img, axis=0)
    img = img / 255.0  # 이미지를 정규화합니다.

    # 이미지를 모델로 예측합니다.
    prediction = MODEL.predict(img)

    # 예측 결과를 해석합니다.
    if prediction < 0.5:
        return 'cat'
    else:
        return 'dog'
