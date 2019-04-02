CREATE TABLE post (
	post_id INTEGER PRIMARY KEY, 
	post_title VARCHAR(20) NOT NULL,
	post_datetime DATE,
	post_content VARCHAR(200),
	memb_id INTEGER,
);
