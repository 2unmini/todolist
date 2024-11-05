# todolist

## API 명세서
### schedule API

|Method|EndPoint|Desc|
|------|---|---|
|<span style="color:gray">POST</span>|/api/schedules|새로운 일정 생성|
|<span style="color:blue">GET</span>|/api/schedules|전체 일정을 가져옴|
|<span style="color:blue">GET</span>|/api/schedules/{schedule_id}|상세 일정을 가져옴|
|<span style="color:purple">PUT</span>|/api/schedules/{schedule_id}|일정을 변경|
|<span style="color:red">DELETE</span>|/api/schedules/{schedule_id}|일정을 삭제|


<details>
<summary>POST 일정 생성</summary>
<div markdown="1">       

/api/schedules
  - Request body

|파라미터|타입  |필수여부|설명  |
|------|------|------|------|
|title |String|O     |제목   |
|username|String|O     |작성자 |
|content  |String|X     |내용   |
|password  |String|O     |비밀번호   |

  ```json
  {
    "title": "제목",
    "username": "작성자" ,
    "content": "내용",
    "password": "비밀번호"
}
  
  ```


- Example response

  
|파라미터|타입  |필수여부|설명  |
|------|------|------|------|
|schedule_id |String|O     |일정 고유번호  |
|title |String|O     |제목   |
|username|String|O     |작성자 |
|content  |String|X     |내용   |
|created_At|String|O     |생성 날짜 |
|updated_At|String|X     |수정 날짜 |



  ```json
  HTTP/1.1 200
  
  {
    "schedule_id": 3,
    "title" : "제목",
    "username": "작성자" ,
    "content": "내용",
    "created_At": "2024-10-30"
    }
  
  ```
</div>
</details>

<details>
<summary>GET 전체 일정 조회</summary>
<div markdown="1">       

/api/schedules
  - Requset
    
  ```http
  curl --location 'https://0dc94331-bdcc-466a-a411-cb33d5c05585.mock.pstmn.io/api/schedules
  ```

- Example response

|파라미터|타입  |필수여부|설명  |
|------|------|------|------|
|schedule_id |String|O     |일정 고유번호  |
|title |String|O     |제목   |
|username|String|O     |작성자 |
|content  |String|X     |내용   |
|created_At|String|O     |생성 날짜 |
|updated_At|String|X     |수정 날짜 |

  
  ```json
  HTTP/1.1 200
  
  [
    {
    "schedule_id": 1,
    "title" : "제목1",
    "username": "작성자1" ,
    "content": "내용1",
    "created_At": "2024-10-30",
    "updated_At": "2024-10-31"
    },
    {
    "schedule_id": 2,
    "title" : "제목2",
    "username": "작성자2" ,
    "content": "내용2",
    "created_At": "2024-10-31"
    }]
  ```

</div>
</details>

<details>
  
<summary>GET 상세 일정 조회</summary>

<div markdown="1">       

/api/schedules/{schedule_id}

  - Requset

|파라미터|타입  |필수여부|설명  |
|------|------|------|------|
|schedule_id    |String|O     |일정 고유번호  |



  ```http
  curl --location 'https://0dc94331-bdcc-466a-a411-cb33d5c05585.mock.pstmn.io/api/schedules/1
  ```

- Example response

|파라미터|타입  |필수여부|설명  |
|------|------|------|------|
|schedule_id |String|O     |일정 고유번호  |
|title |String|O     |제목   |
|username|String|O     |작성자 |
|content  |String|X     |내용   |
|created_At|String|O     |생성 날짜 |
|updated_At|String|X     |수정 날짜 |


   ```json
  HTTP/1.1 200
  {
    "schedule_id": 1,
    "title" : "제목1",
    "username": "작성자1" ,
    "content": "내용1",
    "created_At": "2024-10-30",
    "updated_At": "2024-10-31"}
  ```
</div>
</details>


<details>
<summary>PUT 일정 변경</summary>
<div markdown="1">       

/api/schedules/{schedule_id}

```http
  curl --location 'https://0dc94331-bdcc-466a-a411-cb33d5c05585.mock.pstmn.io/api/schedules/1
  ```

  - Request body
    
|파라미터|타입  |필수여부|설명  |
|------|------|------|------|
|title |String|O     |제목   |
|username|String|O     |작성자 |
|content  |String|X     |내용   |
|password  |String|O     |비밀번호   |


  ```json
  {
    "title" : "제목1",
    "username": "작성자1" ,
    "content": "수정내용"
    "password": "비밀번호"}
  ```

- Example response (성공)

|파라미터|타입  |필수여부|설명  |
|------|------|------|------|
|schedule_id |String|O     |일정 고유번호  |
|title |String|O     |제목   |
|username|String|O     |작성자 |
|content  |String|X     |내용   |
|created_At|String|O     |생성 날짜 |
|updated_At|String|O     |수정 날짜 |
  
  ```json
  HTTP/1.1 200
  
  {
    "schedule_id": 1,
    "title" : "제목1",
    "username": "작성자1" ,
    "content": "수정내용",
    "created_At": "2024-10-30",
    "updated_At": "2024-10-31"}
  ```
  
- Example response (실패)

  ```json
  HTTP/1.1 400
  
  {
    "msg": "수정 실패."}
  ```
</div>
</details>

<details>
<summary>DELETE 일정 삭제</summary>
<div markdown="1">       

/api/schedules/{schedule_id}
  - Requset
    
|파라미터|타입  |필수여부|설명  |
|------|------|------|------|
|schedule_id    |String|O     |일정 고유번호  |


  ```http
  curl --location 'https://0dc94331-bdcc-466a-a411-cb33d5c05585.mock.pstmn.io/api/schedules/1
  ```
- Example response (성공)
- 
  ```json
  HTTP/1.1 200
  
  {
    "msg": "삭제 완료되었습니다."}
  ```
  
- Example response (실패)

  ```json
  
  HTTP/1.1 400
  
  {
    "msg": "삭제 실패."}
  ```
  
</div>
</details>



## ERD

![ERD](https://github.com/user-attachments/assets/dabf5208-8aee-4053-b0c8-089697f135d6)
