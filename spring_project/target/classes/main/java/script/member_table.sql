CREATE TABLE member (
	memb_id INTEGER IDENTITY,
	memb_name VARCHAR(20) NOT NULL, 
	memb_joined DATE
);
insert into member (memb_name, memb_joined) values('김대연','2019-01-01');
insert into member (memb_name, memb_joined) values('김보민','2019-02-02');
insert into member (memb_name, memb_joined) values('송병욱','2019-03-03');
