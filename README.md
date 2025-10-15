# BookAi

Spring Boot와 MongoDB를 활용한 도서 및 저널 관리 시스템입니다.

## 개요

BookAi는 책(Book)과 저널(Journal) 정보를 관리할 수 있는 RESTful API 기반 웹 애플리케이션입니다. Thymeleaf 템플릿 엔진을 사용하여 웹 인터페이스도 제공합니다.

## 주요 기능

- 도서 정보 CRUD (생성, 조회, 수정, 삭제)
- 저널 정보 CRUD
- MongoDB를 활용한 NoSQL 데이터 저장
- RESTful API 제공
- Thymeleaf 기반 웹 UI

## 기술 스택

- **Java 17**
- **Spring Boot 3.3.5**
  - Spring Data MongoDB
  - Spring Web
  - Thymeleaf
- **MongoDB** (NoSQL Database)
- **Gradle** (빌드 도구)
- **JUnit 5** (테스트)

## 프로젝트 구조

```
src/
├── main/
│   └── java/io/github/herbpot/bookai/
│       ├── BookAiApplication.java      # 메인 애플리케이션
│       ├── Controller/
│       │   ├── JournalController.java  # 저널 REST API
│       │   └── MainController.java     # 메인 컨트롤러
│       ├── Repository/
│       │   ├── BookRepository.java     # 도서 데이터 접근
│       │   └── JournalRepository.java  # 저널 데이터 접근
│       ├── Schema/
│       │   ├── Book.java               # 도서 엔티티
│       │   └── Journal.java            # 저널 엔티티
│       └── Service/
│           ├── BookService.java        # 도서 비즈니스 로직
│           └── JournalService.java     # 저널 비즈니스 로직
└── test/
    └── java/io/github/herbpot/bookai/
        ├── BookAiApplicationTests.java
        └── JournalControllerTest.java
```

## 사전 요구사항

- JDK 17 이상
- MongoDB 설치 및 실행
- Gradle (또는 포함된 Gradle Wrapper 사용)

## 설치 및 실행

### 1. 레포지토리 클론

```bash
git clone https://github.com/herbpot/BookAi.git
cd BookAi
```

### 2. MongoDB 실행

로컬 환경에서 MongoDB가 실행 중이어야 합니다.

```bash
# MongoDB 기본 포트: 27017
mongod
```

### 3. 애플리케이션 빌드 및 실행

```bash
# Gradle Wrapper 사용 (Windows)
gradlew.bat bootRun

# Gradle Wrapper 사용 (Linux/Mac)
./gradlew bootRun
```

또는

```bash
# Gradle로 빌드 후 실행
./gradlew build
java -jar build/libs/BookAi-0.0.1-SNAPSHOT.jar
```

애플리케이션은 기본적으로 `http://localhost:8080`에서 실행됩니다.

## 테스트

```bash
./gradlew test
```

## API 엔드포인트 (예상)

### Book API
- `GET /books` - 모든 도서 조회
- `GET /books/{id}` - 특정 도서 조회
- `POST /books` - 도서 추가
- `PUT /books/{id}` - 도서 수정
- `DELETE /books/{id}` - 도서 삭제

### Journal API
- `GET /journals` - 모든 저널 조회
- `GET /journals/{id}` - 특정 저널 조회
- `POST /journals` - 저널 추가
- `PUT /journals/{id}` - 저널 수정
- `DELETE /journals/{id}` - 저널 삭제

## 설정

MongoDB 연결 설정은 `src/main/resources/application.properties` 또는 `application.yml`에서 수정할 수 있습니다.

## 라이선스

MIT License

## 기여

이슈 및 풀 리퀘스트는 언제나 환영합니다!
