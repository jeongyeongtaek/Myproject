drop sequence seq_post;
drop sequence seq_hash_tag;

drop table tbl_map_post_tag;
drop table tbl_map_party_tag;
drop table tbl_hash_tag;
drop table tbl_post;
drop table tbl_contact_point;
drop table tbl_party;
drop table tbl_board;
drop table tbl_role;
drop table tbl_contact_point_type;

drop table tbl_chatroom;
drop table tbl_chat_message;
drop table tbl_chatroom_participant;


create table tbl_role(
	name		varchar2(50) primary key,
	prior_name	varchar2(50)
);

--id, name
create table tbl_board(
	id 			number(10) primary key, 
	name		varchar2(200)
);
insert into tbl_board values(1, '자유게시판');

--	login_id, pwd, name
create table tbl_party(
	login_id	varchar2(200) primary key,
	pwd			varchar2(2000),
	name		varchar2(200),
	role_name	varchar2(50)
);

create table tbl_contact_point_type (
	type_name   varchar2(200)
	-- 화면 구성 순서, caption 정보
);

--	login_id, type_name, contact_point
create table tbl_contact_point(
	login_id	varchar2(200),
	type_name   varchar2(200),
	contact_point varchar2(200),
	primary key(login_id, type_name)
);
ALTER TABLE tbl_contact_point
	ADD CONSTRAINTS fk_party_from_cp FOREIGN KEY (login_id)
	REFERENCES tbl_party(login_id);

create sequence seq_post;

--	hierarchy_id, obj_type, content, writer_id, board_id, title
create table tbl_post(
	hierarchy_id varchar2(2000) primary key,	-- composite pattern delimeter '_' 성능도 보장됨 
	obj_type	char NOT NULL,	-- 게시글 : P, 댓글 : R
	--댓글에서 정의하는 항목은 게시글에서도 상속 관계에 의하여 활용됨
	content		varchar2(2000),
	writer_id	varchar2(200),
	--게시글일때 추가되는 정보
	board_id	number(10),
	title		varchar2(200)
); 

create sequence seq_hash_tag;

--id, name, descript
create table tbl_hash_tag(
	id			number(10)	 primary key,
	name		varchar2(200),
	descript	varchar2(2000)
);
create index idx_hash_tag_name on tbl_hash_tag(name);

--login_id, tag_id
create table tbl_map_party_tag(
	login_id	varchar2(200),
	tag_id		number(10),
	primary key(login_id, tag_id)
);

--post_id, tag_id
create table tbl_map_post_tag(
	post_id		varchar2(2000),
	tag_id		number(10),
	primary key(tag_id, post_id)
);

create table tbl_chatroom (
    chatroom_id     varchar2(200),
    chatroom_name     varchar2(200)
);

create table tbl_chat_message (
    chatroom_id     varchar2(200),
    party_id        varchar2(200),
    message         varchar2(2000),
    message_send_time date
);

create index idx_message_send_time on tbl_chat_message(message_send_time);
  
create table tbl_chatroom_participant (
    chatroom_id     varchar2(200),
    party_id        varchar2(200),
    primary key (chatroom_id, party_id)
);

