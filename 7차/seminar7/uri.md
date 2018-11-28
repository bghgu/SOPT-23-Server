# URI

## Users

| 메소드 | 경로                      | 설명                           |
| ------ | ------------------------- | ------------------------------ |
| GET    | /users/{userIdx}          | 회원 정보 조회                 |
| POST   | /users                    | 회원 가입                      |
| PUT    | /users/{userIdx}          | 회원 정보 수정                 |
| DELETE | /users/{userIdx}          | 회원 탈퇴                      |

## Contents

| 메소드 | 경로                   | 설명             |
| ------ | ---------------------- | ---------------- |
| GET    | /contents              | 모든 게시글 조회 |
| GET    | /contents/{contentIdx} | 게시글 조회      |
| GET    | /users/{userIdx}/contents | 해당 회원이 작성한 컨텐츠 조회 |
| POST   | /contents              | 게시글 작성      |
| PUT    | /contents/{contentIdx} | 게시글 수정      |
| DELETE | /contents/{contentIdx} | 게시글 삭제      |

## ContentLikes

| 메소드 | 경로                         | 설명                      |
| ------ | ---------------------------- | ------------------------- |
| GET    | /contents/{contentIdx}/likes | 해당 게시글의 좋아요 조회 |
| POST   | /contents/{contentIdx}/likes | 해당 게시글 좋아요        |
| DELETE | /contents/{contentIdx}/likes | 해당 게시글 좋아요 취소   |

## Comments

| 메소드 | 경로                            | 설명                         |
| ------ | ------------------------------- | ---------------------------- |
| GET    | /contents/{contentIdx}/comments | 해당 게시글의 모든 댓글 조회 |
| GET    | /users/{userIdx}/comments       | 해당 회원이 작성한 댓글 조회 |
| POST   | /contents/{contentIdx}/comments | 해당 게시글에 댓글 작성      |
| PUT    | /comments/{commentIdx}          | 댓글 수정                    |
| DELETE | /comments/{commentIdx}          | 댓글 삭제                    |

## CommentLikes

| 메소드 | 경로                         | 설명                    |
| ------ | ---------------------------- | ----------------------- |
| GET    | /comments/{commentIdx}/likes | 해당 댓글의 좋아요 조회 |
| POST   | /comments/{commentIdx}/likes | 해당 댓글의 좋아요      |
| DELETE | /comments/{commentIdx}/likes | 해당 댓글의 좋아요 취소 |

