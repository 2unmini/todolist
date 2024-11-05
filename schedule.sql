schedule 테이블 생성

CREATE TABLE schedule
(
    schedule_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL ,
    username VARCHAR(50) NOT NULL ,
    content VARCHAR(100) NULL ,
    password VARCHAR(20) NOT NULL ,
    created_at DATE NOT NULL ,
    updated_at DATE NULL,
    PRIMARY KEY (schedule_id)
)

일정 추가
insert into schedule (title,userName,content,password)
values("제목,"작성자명",내용","비밀번호");

전체 일정 조회
select *
from schedule;

상세 일정 조회
select *
from schedule
where schedule_id = 고유번호;

선택 일정의 제목 변경 
update schedule set title = 입력값
where schedule_id = 고유번호;


선택 일정의 내용 변경
update schedule set content = 입력값
where schedule_id = 고유번호;

일정 삭제
delete from schedule
where  schedule_id = 고유번호;
