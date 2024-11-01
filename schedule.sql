user 테이블 생성
CREATE TABLE user (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`));

schedule 테이블 생성

CREATE TABLE schedule (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `writer_id` INT NOT NULL,
  `content` VARCHAR(100) NULL,
  `reg_date` DATE NOT NULL,
  `mod_date` DATE NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`schedule_id`),
  INDEX `fk_schedule_user_idx` (`writer_id` ASC) ,
  CONSTRAINT `fk_schedule_user`
    FOREIGN KEY (`writer_id`)
    REFERENCES user (`user_id`);

일정 추가
insert into schedule (title,content,password)
values("제목,내용","비밀번호");

전체 일정 조회
select schedule.*,user.name AS writer
from schedule
join user on schedule.writer_id=user.user_id;

상세 일정 조회
select schedule.*,user.name AS writer
from schedule
join user on schedule.writer_id=user.user_id;
where schedule.schedule_id = 고유번호;

선택 일정의 제목 변경 
update schedule set title = 입력값
where schedule_id = 고유번호;


선택 일정의 내용 변경
update schedule set content = 입력값
where schedule_id = 고유번호;

일정 삭제
delete from schedule
where  schedule_id = 고유번호;
