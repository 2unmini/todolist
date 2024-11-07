user 테이블 생성
    
CREATE TABLE user
(
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NULL,
    PRIMARY KEY (user_id)
);



schedule 테이블 생성

CREATE TABLE schedule
(
    schedule_id INT          NOT NULL AUTO_INCREMENT,
    user_id    INT          NOT NULL,
    title      VARCHAR(45)  NOT NULL,
    content    VARCHAR(210) NOT NULL,
    created_at DATE         NOT NULL,
    updated_at DATE         NULL,
    password   VARCHAR(45)  NOT NULL,
    PRIMARY KEY (`schdule_id`),
    INDEX `fk_schedule_user_idx` (`user_id`),
    CONSTRAINT `fk_schedule_user`
        FOREIGN KEY (`user_id`)
            REFERENCES user (`user_id`)
);
사용자 정보 조회
select *
from user 
where user_id = 고유번호;

사용자 정보 수정
update user set user_name = 입력값, email= 입력값
where user_id = 고유번호;


전체 일정 조회
select *
from schedule;

상세 일정 조회
select *
from schedule
where schedule_id = 고유번호;

선택 일정의 내용 변경 
update schedule set title = 입력값 , content = 입력값 , update_at = 등록시간
where schedule_id = 고유번호 and password = 입력값;


일정 삭제
delete from schedule
where  schedule_id = 고유번호 and password = "입력값";

페이지네이션 조회
select *
from schedule,user limit (입력값1 -1)*입력값2,입력값2;


