import cv2
import requests
import json


def kakao_pic():
    image_url = "https://docs.opencv.org/3.4/lena.png"
    # API주소
    API_URL = 'https://dapi.kakao.com/v2/vision/face/detect'
    # REST API 키
    MYAPP_KEY = '2b712cb6a2c570831e118a005bd718fe'

    headers = {'Authorization': 'KakaoAK {}'.format(MYAPP_KEY)}
    # data = {'image_url': image_url}
    # resp = requests.post(API_URL, headers=headers, data=data)
    path = ''
    file = 'lena.jpg'
    files = {'image': open(path + file, "rb")}

    resp = requests.post(API_URL, headers=headers, files=files)

    # <Response [200]>가 아니면 에러 발동
    resp.raise_for_status()

    # json문자열 디코딩
    result = json.loads(resp.text)

    male = result['result']['faces'][0]['facial_attributes']['gender']['male']
    female = result['result']['faces'][0]['facial_attributes']['gender']['female']
    age = int(result['result']['faces'][0]['facial_attributes']['age'])

    face_info = {"male": male, "female": female, "age": age}
    print(f"남자일 확률 : {round(float(face_info.get('male')) * 100, 2)}%")
    print(f"여자일 확률 : {round(float(face_info.get('female')) * 100, 2)}%")
    print(f"추정 나이 : {face_info.get('age')}")


if __name__ == '__main__':
    # 이미지 읽기
    img = cv2.imread('lena.jpg', 1)
    kakao_pic()
    cv2.imshow('original', img)

    cv2.waitKey(0)
    # 이미지 윈도우 삭제
    cv2.destroyAllWindows()
