## 로그인

| 메소드 | 경로   | 짧은 설명 |
| ------ | ------ | --------- |
| POST   | /login | 로그인    |

### 요청 헤더

```json
Content-Type: application/json
```

### 요청 바디

```json
{
    "email": "bghgu@naver.com",
    "password": "1234"
}
```

### 응답 바디

#### 로그인 성공

```json
{
    "status": 200,
    "message": "로그인 성공",
    "data": {
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJEb0lUU09QVCIsInVzZXJfaWR4IjoxfQ.5lCvAqnzYP4-2pFx1KTgLVOxYzBQ6ygZvkx5jKCFM08"
    }
}
```
*  토큰 만료 기간 : 1달

#### 로그인 실패

```json
{
    "status": 400,
    "message": "로그인 실패",
    "data": null
}
```
#### INTERNAL SERVER ERROR

```json
{
    "status": 500,
    "message": "서버 내부 에러",
    "data": null
}
```
------

