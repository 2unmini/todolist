# todolist

## API 명세서
### schedule API

|Method|EndPoint|Desc|
|------|---|---|
|<span style="color:gray">POST</span>|/api/tasks|새로운 일정 생성|
|<span style="color:blue">GET</span>|/api/tasks|전체 일정을 가져옴|
|<span style="color:blue">GET</span>|/api/tasks/{task_id}|상세 일정을 가져옴|
|<span style="color:purple">PUT</span>|/api/tasks/{task_id}|일정을 변경|
|<span style="color:red">DELETE</span>|/api/tasks/{task_id}|일정을 삭제|


<details>
<summary>POST 일정 생성</summary>
<div markdown="1">       

/api/tasks
  - Request body
  ```json
  {
    "id": 3,
    "title": "10월 31일 뭐하지",
    "regdate": "2024-10-30",
    "writer": "스파르타",
    "desc": "가나다라"}
  
  ```
- Example response
  ```json
  HTTP/1.1 200
  
  {
    "msg": "추가완료되었습니다."}
  
  ```
</div>
</details>

<details>
<summary>GET 전체 일정 조회</summary>
<div markdown="1">       

/api/tasks
  - Requset
    
  ```http
  curl --location 'https://0dc94331-bdcc-466a-a411-cb33d5c05585.mock.pstmn.io/api/tasks
  ```

- Example response
  
  ```json
  HTTP/1.1 200
  
  [
    {
        "id": 1,
        "title": "10월 29일 뭐하지",
        "regdate": "2024-10-29",
        "writer": "천준민",
        "desc": "가나다라"
    },
    {
        "id": 2,
        "title": "10월 30일 뭐하지",
        "regdate": "2024-10-30",
        "writer": "스파르타",
        "desc": "가나다라"
    }]
  ```

</div>
</details>

<details>
  
<summary>GET 상세 일정 조회</summary>

<div markdown="1">       

/api/tasks/{task_id}

  - Requset

  ```http
  curl --location 'https://0dc94331-bdcc-466a-a411-cb33d5c05585.mock.pstmn.io/api/tasks/1
  ```

- Example response

   ```json
  HTTP/1.1 200
  {
    "id": 1,
    "title": "10월 30일 뭐하지",
    "regdate": "2024-10-30",
    "writer": "천준민",
    "desc": "가나다라"}
  ```
</div>
</details>


<details>
<summary>PUT 일정 변경</summary>
<div markdown="1">       

/api/tasks/{task_id}

  - Request body

  ```json
  {
    "id": 3,
    "title": "10월 31일 뭐하지",
    "regdate": "2024-10-30",
    "moddate": "2024-10-31"
    "writer": "스파르타",
    "desc": "가나다라"}
  ```

- Example response (성공)
  
  ```json
  HTTP/1.1 200
  
  {
    "msg": "수정 완료되었습니다."}
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

/api/tasks/{task_id}
  - Requset
  ```http
  curl --location 'https://0dc94331-bdcc-466a-a411-cb33d5c05585.mock.pstmn.io/api/tasks/1
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