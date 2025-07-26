# Deploy Backend Post

Spring Boot 기반의 게시글 API 서버입니다. 이 프로젝트는 MySQL 데이터베이스를 사용하여 게시글을 관리하는 RESTful API를 제공합니다.

## 기술 스택

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- MySQL 8
- Docker & Docker Compose
- Swagger (API 문서화)
- Lombok

## 프로젝트 구조

```
deploy-backend-post/
├── src/main/java/com/dsg/deploybackendpost/
│   ├── config/         - 설정 클래스
│   ├── controller/     - API 컨트롤러
│   ├── dto/            - 데이터 전송 객체
│   ├── entity/         - JPA 엔티티
│   ├── init/           - 초기 데이터 설정
│   ├── props/          - 프로퍼티 클래스
│   ├── repository/     - 데이터 접근 레이어
│   └── service/        - 비즈니스 로직
└── src/main/resources/
    └── application.yml - 애플리케이션 설정
```

## 설치 및 실행 방법

### 사전 요구사항

- Java 17 이상
- Docker 및 Docker Compose
- Git

### 환경 설정

1. 프로젝트 클론

   ```bash
   git clone https://github.com/yourusername/deploy-backend-post.git
   cd deploy-backend-post
   ```

2. 환경 변수 설정
   `.env` 파일을 프로젝트 루트 디렉토리에 생성하고 다음 내용을 추가합니다:
   ```
   MYSQL_ROOT_PASSWORD=rootpassword
   MYSQL_DATABASE=post
   MYSQL_USER=post
   MYSQL_PASSWORD=post
   ```

### 데이터베이스 실행

Docker Compose를 사용하여 MySQL 데이터베이스를 실행합니다:

```bash
docker-compose up -d
```

### 애플리케이션 빌드 및 실행

Gradle을 사용하여 애플리케이션을 빌드하고 실행합니다:

```bash
# Windows
./gradlew.bat build
./gradlew.bat bootRun

# Linux/Mac
./gradlew build
./gradlew bootRun
```

또는 빌드 후 JAR 파일을 직접 실행할 수도 있습니다:

```bash
java -jar build/libs/deploy-backend-post-0.0.1-SNAPSHOT.jar
```

## API 엔드포인트

애플리케이션이 실행되면 다음 API 엔드포인트를 사용할 수 있습니다:

- `GET /api/posts` - 모든 게시글 조회
- `GET /api/posts/{id}` - 특정 게시글 조회
- `POST /api/posts` - 새 게시글 생성
- `PUT /api/posts/{id}` - 게시글 수정
- `DELETE /api/posts/{id}` - 게시글 삭제

## Swagger UI

API 문서는 Swagger UI를 통해 확인할 수 있습니다:

```
http://localhost:8080/swagger-ui/index.html
```

## 프로필 설정

애플리케이션은 다음과 같은 프로필을 지원합니다:

- `local` - 로컬 개발 환경 (기본값)
- `prod` - 운영 환경

프로필을 변경하려면 다음과 같이 실행합니다:

```bash
./gradlew bootRun --args='--spring.profiles.active=prod'
```

또는 JAR 파일 실행 시:

```bash
java -jar build/libs/deploy-backend-post-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

## 테스트

다음 명령으로 테스트를 실행할 수 있습니다:

```bash
./gradlew test
```
