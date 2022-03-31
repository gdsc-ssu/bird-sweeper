![img](https://user-images.githubusercontent.com/64878866/161077367-5f966376-3b97-4e84-9df8-3484fdd618d9.png)

# Bird Sweeper : Clean streets free of cigarette butts

**Bird-sweeper is a project designed to create a clean street by collecting garbage through wild birds.** The goal is to efficiently remove environmental waste from the streets by repeating the process of providing food as compensation when birds bring garbage. And also expected to statistize collected waste to notify the seriousness of environmental pollution, while also reducing numerous costs of cleaning up previously based on collected statistics.

---

## Overview

### Architecture Diagram

<p align="center">
  <img width="90%" src="https://user-images.githubusercontent.com/64878866/161077417-6761037e-21ef-4915-8294-50f71925cc7e.png" />
</p>

**Built With**

- Hardware : Raspberry Pi, Python, GPIO, Google Cloud Vison Api
- Mobile-App : Flutter, Google Maps
- Backend Server : Java, Spring Boot, Gradle
- Infra : GCP Compute Engine, GCP Cloud SQL

### Cycle Roadmap

The core of this project is "learning birds through compensation." Highly intelligent (e.g., crows) birds have trained bird-sweeper dispensers to provide food for specific waste, reducing environmental waste and allowing wild animals to eat safe food. And also reports raw data collected by hardware and uses it as a variety of insights to improve environmental pollution.

### Hardware Architecture

Usually, when birds bring garbage, it acts as a mechanism to feed and transmit raw data to the server. Below are the operating mechanisms for each function.

<p align="center">
  <img width="720px" src="https://user-images.githubusercontent.com/64878866/161077472-258adba9-ce7d-4a43-a9e0-acb43c152e60.png" />
</p>

1. **Machine learning recognizes birds**

   Recognize ****birds through camera connected to Raspberry Pi. The camera is mounted at the top of the dispenser, allowing efficient bird recognition through a wide viewing angle. We controls the camera, takes pictures every 5 seconds by using OpenCV, and analyzes them through machine learning. We use Google's `Google Cloud Vison` because the analysis process needs to be fast and accurate. We use Python to load `Google Cloud Vison SDK` and analyze the photos. Based on the results returned by Google Cloud Vison, we will move on to the next step. 

2. **Garbage recognizing Machine learning**

   In the same way as in the previous number 1, Trash is recognized through machine learning. Use Google Cloud Vision to recognize both birds and trash. If `Tobacco` or `Cigarette` or `Smoking` or `Tobacco Products` are in the analysis results, we recognize that bird has put trash in dispenser and will move on to the feeding stage.

3. **Data statistics transmission after garbage recognition**

   Now, the information garbage collected and device status should be delivered to the server so that it can be checked through the app. Every hour, Raspberry Pi reports the information  to the server about remaining amount of food container, the amount of garbage collected, and the status information of the senses. Once this information is delivered to the server, We use `Google Firestore` to manage the database, which will be used in application.

4. **Feeding birds as a reward**

   When `Google Cloud Vision` recognizes birds and garbage, it opens the entrance through the servo-motor to provide food. The `HS-311` servo-motor is used to control the entrance of the food tank. The food tank has a structure in which food can fall naturally by gravity, and by opening the entrance, food is provided using gravity.

5. **Sensor-controlled residual food**

   Now, To  control the state of dispenser remotely,  measure data of the remaining food and garbage tank. We use ultrasonic sensors  to measure. We use the ultrasonic sensors to determine the height of the food tank and the trash can  determine how much it is. Then, the results will be sent to the server.

### Software Architecture

The data collected through the dispenser is displayed in an insatiable manner. In addition, you can check the status of each dispenser immediately.

![img](https://user-images.githubusercontent.com/64878866/161077057-ffeac5eb-bdf1-4ad8-a13f-c11f13d4c5ef.png)

1. **Dispenser Management**

   In charge of their dispensing equipment, data collected in each dispenser and status of the screen that can be found. For more information, collected garbage and consumption system regulates the kind of animals and to visit in check by period and, in dispensers in addition there are more than check immediately in cases, applications and manage.

   ![img](https://user-images.githubusercontent.com/64878866/161077629-22050bd1-2d35-4a4d-bcf0-f3387ae80589.png)

2. **Report on collected waste**

   You can check the information collected from all dispensers on the statistics screen. From the total amount of garbage collected to the number and type of animals visited to the managers of the world who manage bird sweepers, you can view all the data in one place.

   ![img](https://user-images.githubusercontent.com/64878866/161077657-63ef8270-497b-4f83-b1eb-d49dc52fe014.png)

---

## Test Result

### Bird recognition rate

Statistics on the new recognition rate of Bird-Sweeper machine learning. The recognition rate for each animal is accurately recognized up to an average of 91.43%.

|label|accuracy|
|:---:|:---:|
| Bird          | 95.8% |
| Crow          | 91.3% |
| Perching bird | 87.2% |

### Garbage Recognition Rate

Statistics on the recognition of cigarette butts in Bird Sweeper Machine Learning. Recognition accuracy is recognized accurately up to an average of 87.2%.

|label|accuracy|
|:---:|:---:|
| Tobacco          | 90.1% |
| Cigarette        | 88.4% |
| Smoking          | 82.9% |
| Tobacco Products | 87.4% |

---

## Demo Video

[![Video Label](http://img.youtube.com/vi/uEabuhi1hIE/0.jpg)](https://youtu.be/uEabuhi1hIE)

---
