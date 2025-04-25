# 🔐 Crypto_Utils

입력한 텍스트를 다양한 해시 알고리즘(SHA1, SHA256, SHA512)으로 변환해주는 간단한 웹 애플리케이션입니다.  
Spring Boot와 Java로 백엔드를 구성하고, HTML/CSS/JavaScript로 프론트엔드를 제작한 포트폴리오용 프로젝트입니다.

---

## ✨ 주요 기능

- SHA1 / SHA256 / SHA512 해시 알고리즘 지원
- 해시 결과를 대문자 또는 소문자로 출력 선택 가능
- 간단한 웹 UI 제공
- JSON 응답 기반 처리

---

## 🛠 사용 기술 스택

### 📌 백엔드
- **Java 17**
- **Spring Boot**
- Spring MVC (Controller, Service)
- MessageDigest (Java 표준 암호화 라이브러리 사용)

### 🎨 프론트엔드
- **HTML**
- **CSS**
- **JavaScript**
- 입력 폼 처리 및 결과 출력

---

## 🖥 화면 예시

- ### 🔹 처음 화면  
  사용자가 해시할 텍스트와 옵션을 선택할 수 있는 기본 화면입니다.

  <img width="532" alt="처음 화면" src="https://github.com/user-attachments/assets/f5cf9e1b-2119-491a-a921-87cc8986799d" />

---

- ### ❗ 입력을 하지 못했을 경우  
  텍스트 입력 없이 실행하면 오류 메시지를 반환합니다.

  <img width="571" alt="입력 오류" src="https://github.com/user-attachments/assets/a5f68b1f-ac00-4d5b-ad20-f8d2abfff6f7" />

---

- ### ✅ 입력을 하였을 경우  
  선택한 알고리즘으로 해시된 결과가 출력됩니다.

  <img width="610" alt="입력 결과" src="https://github.com/user-attachments/assets/62a49fe0-57b4-479b-a89c-c43c7c2d7827" />



---
