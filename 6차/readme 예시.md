# project-sopt

API 문서 : https://github.com/bghgu/SOPT-23-API-SERVER/wiki

## 시작하기

모든 소스코드는 IntelliJ IDEA + Window10 + JAVA 8 환경에서 작성되었습니다.

이 프로젝트에서는 아래 같은 **MAVEN 의존성 프로젝트**가 포함되어있습니다. 

```
    <dependencies>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <version>8.5.20</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-aws</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.8.11</version>
        </dependency>

        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
            <version>3.4.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jdbc</artifactId>
            <version>8.5.23</version>
        </dependency>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-java-sdk-s3</artifactId>
            <version>1.11.125</version>
        </dependency>

    </dependencies>
```

## 실행하기

### window 10 환경 기준

- 8080 포트를 사용합니다.

- `jdk8` 과 `maven` 을 설치합니다.

- `JAVA_JOME` 환경변수 설정을 합니다.

- `Path`에 `maven` 환경변수 설정을 합니다.

- 내장 톰캣을 이용해 서버를 배포 합니다.

- `application.properties` 파일이 필요합니다.

- spring boot 앱 실행

  ```
  mvn spring-boot:run
  ```

- 중지하려면, 키보드에서 `Crtl + C`를 누릅니다.

### AWS EC2 Ubuntu 환경

* 8080 포트를 사용합니다.

- `jdk8` 과 `maven` 을 설치합니다.

- 백 그라운드 spring boot 앱 실행

- 내장 톰캣을 사용해 배포합니다.

- `application.properties` 파일이 필요합니다.

- spring boot 앱 실행

  ```
  nohup mvn spring-boot:run&
  ```

- 중지하려면,  `netstat -tnlp` 명령어를 통해 프로세스를 kill 하십시오.

## 배포

- AWS EC2 - 애플리케이션 서버
- AWS RDS - Mysql DB 5.7
- AWS S3 - Cloud File Storage

## 사용된 도구

- [Spring-boot](https://projects.spring.io/spring-boot/) - Spring-boot 웹 프레임워크
- [Maven](https://maven.apache.org/) - 의존성 관리 프로그램
- [Tomcat](http://tomcat.apache.org/) - 웹 애플리케이션 서버
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE
- [MySql](https://www.mysql.com/) - DataBase
- [AWS EC2](https://aws.amazon.com/ko/ec2/?sc_channel=PS&sc_campaign=acquisition_KR&sc_publisher=google&sc_medium=english_ec2_b&sc_content=ec2_e&sc_detail=aws%20ec2&sc_category=ec2&sc_segment=177228231544&sc_matchtype=e&sc_country=KR&s_kwcid=AL!4422!3!177228231544!e!!g!!aws%20ec2&ef_id=WkRozwAAAnO-lPWy:20180412120123:s) - 클라우드 환경 컴퓨팅 시스템
- [AWS RDS](https://aws.amazon.com/ko/rds/) - 클라우드 환경 데이터베이스 관리 시스템
- [AWS S3](https://aws.amazon.com/ko/s3/) - 클라우드 환경 객체 스토리지

## 저자

- **배다슬** - [bghgu](https://github.com/bghgu)
