import requests
import json

url = "https://dapi.kakao.com/v2/search/image"
queryString = {"query": "아리"}
header = {'authorization': 'KakaoAK 26a57e202a118708213a612eee4232fa'}
r = requests.get(url, headers=header, params=queryString)
jsonr = json.loads(r.text)
documents = jsonr["documents"]
for document in documents:
    # print(list(document.values()))
    print(document["collection"], end="\t")
    print(document["datetime"], end="\t")
    print(document["display_sitename"], end="\t")
    print(document["doc_url"], end="\t")
    print(document["height"], end="\t")
    print(document["image_url"], end="\t")
    print(document["thumbnail_url"], end="\t")
    print(document["width"])
