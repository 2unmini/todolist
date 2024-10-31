user 테이블 생성
CREATE TABLE user (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`));

schedule 테이블 생성

CREATE TABLE schedule (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `writer_id` INT NOT NULL,
  `desc` VARCHAR(100) NULL,
  `reg_date` DATE NOT NULL,
  `mod_date` DATE NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_schedule_user_idx` (`writer_id` ASC) ,
  CONSTRAINT `fk_schedule_user`
    FOREIGN KEY (`writer_id`)
    REFERENCES user (`id`);

일정 추가
insert into schedule (title,desc,password)
values("제목,내용","비밀번호");

전체 일정 조회
select schedule.*,user.name AS writer
from schedule
join user on schedule.writer_id=user.id;

상세 일정 조회
select schedule.*,user.name AS writer
from schedule
join user on schedule.writer_id=user.id;
where schedule.id = 고유번호;

선택 일정의 제목 변경 
update schedule set title = 입력값
where id = 고유번호;


선택 일정의 내용 변경
update schedule set desc = 입력값
where id = 고유번호;

일정 삭제
delete from schedule
where id = 고유번호;
