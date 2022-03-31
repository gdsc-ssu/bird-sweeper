import os 
import io 
import time
import cv2

import requests
import json

#먹이량 감지
import checkingDispenser
#쓰레기량 감지
import checkingTrash
# 서보모터 제어
import dispensingFood


os.environ['GOOGLE_APPLICATION_CREDENTIALS'] = 'gdsc.json'
from google.cloud import vision # Instantiates a client 


def detectBirdwithTobacco():
    client = vision.ImageAnnotatorClient() # The name of the image file to annotate 

    file_list = os.path.abspath('image/')
    file_name = file_list +'/'+sorted(os.listdir(file_list))[-1]    #최신 찍힌 이미지 불러오기
    
    with io.open(file_name, 'rb') as image_file: 
        content = image_file.read() 

    image = vision.Image(content=content) # Performs label detection on the image file 
    response = client.label_detection(image=image) 
    labels = response.label_annotations 

    print('Labels:') 
    for label in labels: 
        print(label.description)

    if 'Bird' or 'Tobacco' or 'Cigarette' or 'Somking' or 'Tobacco Products' in labels:
        print('Detected')
        dispenseFood()
#서보모터를 통해 먹이주기
def dispenseFood():
    print('dispenseFood')
    dispensingFood.main()
#먹이통 퍼센트 계산하기
def checkDispenser():
    print("checkDispenser")
    result = checkingDispenser.main()
    return result
#쓰레기통 퍼센트 계산하기
def checkTrashcan():
    print("checkTrashcan")
    result = checkingTrash.main()
    return result

def check_status():
    try:
        cap = cv2.VideoCapture(0)
        ret, frame = cap.read()
    except:
        return "ERROR"
    return "NORMAL"

#n시간 마다 서버에 데이터 전송하기
def sendData():
    feed = checkDispenser()
    trash = checkTrashcan()
    motionStatus = check_status()
    motorStatus = dispensingFood.check_status()
    url = "http://34.64.122.168:8080/api/dispenser/1"

    payload = json.dumps({
        "code": "testdispenser1",
        "feedPercent": feed,
        "trashPercent": trash,
        "motionStatus": motionStatus,
        "motorStatus": motorStatus
    })
    headers = {
        'X-AUTH-TOKEN': 'MY-TOKEN',
        'Content-Type': 'application/json'
    }

    response = requests.request("POST", url, headers=headers, data=payload)
    print(response.text)

def main():
    cap = cv2.VideoCapture(0)
    a = 0
    while True:
        if time.localtime().tm_min <= 0: #분이 0일때 즉 정각일 때마다 상태를 업데이트 하는 호출을 보낸다
            sendData()    
            
        #촬영 시작 후 이미지 저장
        ret, frame = cap.read()
        cv2.imwrite('./image/image%s.jpg' %a, frame)
        
        detectBirdwithTobacco()
        #메인 함수의 마무리 : 이미지를 보낸다
        time.sleep(5)           #5초마다 실행해 새와 담배꽁초가 발견되었는지 검출한다
        
        print(a)    #5초마다 실행이 잘 되고있는지 파악하기 위함
        a += 1
    cap.release()
    cv2.destroyAllWindows()

if __name__ == '__main__':
    main() 