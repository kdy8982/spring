CREATE TABLE post (
	post_id INTEGER PRIMARY KEY, 
	post_title VARCHAR(20) NOT NULL,
	post_datetime DATE,
	post_content VARCHAR(200)
);
insert into post values('1','안녕하세요. 신입입니다.','2019-01-01','앞으로 잘부탁드립니다');
insert into post values('2','안녕하세요. 주임입니다.','2019-01-01','하하 안녕하십니까');
insert into post values('3','안녕하세요. 대리입니다.','2019-01-01','대리대리 김대리');