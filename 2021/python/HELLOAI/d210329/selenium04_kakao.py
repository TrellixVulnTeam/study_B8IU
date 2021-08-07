# Ch_selenium/example/tutorial1.py
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import requests
import json
import speech_recognition as sr

url = "https://kakaoi-newtone-openapi.kakao.com/v1/recognize"
rest_api_key = 'adb174ed9071842964dcd029e2ea63d2'
driver = webdriver.Chrome('./chromedriver')  # 또는 chromedriver.exe
driver.implicitly_wait(15)  # 묵시적 대기, 활성화를 최대 15초가지 기다린다.

if __name__ == '__main__':

    # 페이지 가져오기(이동)
    driver.get('http://192.168.41.4:5000/')
    driver.find_element_by_xpath('/html/body/a[2]').click()

    id_box = driver.find_element_by_xpath('//*[@id="user_id"]')
    id_box.send_keys('s00002')
    pw_box = driver.find_element_by_xpath('//*[@id="pwd"]')
    pw_box.send_keys('2')
    driver.find_element_by_xpath('/html/body/form/input[3]').click()
    driver.find_element_by_xpath('/html/body/a[2]').click()

    header = {
        "Content-Type": "application/octet-stream",
        "X-DSS-Service": "DICTATION",
        "Authorization": "KakaoAK " + rest_api_key,
    }
    r = sr.Recognizer()
    while True:

        with sr.Microphone(sample_rate=16000) as source:
            print()
            print('==== 마이크에 대고 말씀해주세요 ====')
            audio = r.listen(source)
        res = requests.post(url, headers=header, data=audio.get_raw_data())
        try:
            if len(res.text[res.text.index('{"type":"errorCalled"'):res.text.rindex('}') + 1]) > 0:
                print('음성인식이 안됫됐됫됐됫뙛습니다')
                continue
        except Exception as e:
            print(e)
            pass
        result_json_string = res.text[res.text.index('{"type":"finalResult"'):res.text.rindex('}') + 1]
        result = json.loads(result_json_string)

        print("인식 결과 : ", result['value'])
        if "종료".__eq__(result['value']):
            print("====종료되었습니다====")
            break
        if "가져와".__eq__(result['value']):
            trs = driver.find_elements_by_xpath('/html/body/table/tbody/tr/td[1]/table/tbody/tr')
            for i, tr in enumerate(trs):
                if i != 0:
                    print(tr.find_elements_by_tag_name('td')[2].text)
