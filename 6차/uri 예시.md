# URI

## Contents

| 메소드 | 경로                                                        | 설명                   |
| ------ | ----------------------------------------------------------- | ---------------------- |
| Get    | /contents/{content_id}                                      | 컨텐츠 조회            |
| Get    | users/{user_id}/contents?offset={page_no}&limit={page_size} | 작성자id로 컨텐츠 조회 |
| Post   | /contents                                                   | 컨텐츠 작성            |
| Put    | /contents/{content_id}                                      | 해당 컨텐츠 수정       |
| Delete | /contents/{content_id}                                      | 해당 컨텐츠 삭제       |

## Following

| 메소드 | 경로                                                         | 설명                         |
| ------ | ------------------------------------------------------------ | ---------------------------- |
| Post   | /users/{user_id}/following/{following_id}                    | 팔로우                       |
| Delete | /users/{user_id}/following/{following_id}                    | 상대방 팔로우 해제           |
| Get    | /users/{user_id}/following?offset={page_no}&limit={page_size} | 내가 팔로우한 사람 명단 조회 |
| Get    | /users/{user_id}/following/count                             | 내가 팔로우한 사람 수 조회   |

## Followers

| 메소드 | 경로                                                         | 설명                         |
| ------ | ------------------------------------------------------------ | ---------------------------- |
| Get    | /users/{user_id}/followers?offset={page_no}&limit={page_size} | 나를 팔로우한 사람 명단 조회 |
| Get    | /users/{user_id}/followers/count                             | 나를 팔로우한 사람 수 조회   |

## Feeds

| 메소드 | 경로                                                      | 설명         |
| ------ | --------------------------------------------------------- | ------------ |
| Get    | /users/{user_id}/feeds?offset={page_no}&limit={page_size} | 내 피드 조회 |