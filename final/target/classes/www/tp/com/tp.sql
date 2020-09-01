drop sequence seq_project;
drop sequence seq_hash_tag;

drop table tbl_role;
drop table tbl_board;
drop table tbl_project;
drop table tbl_project_addinfo;
drop table tbl_party;
drop table tbl_party_addinfo;
drop table tbl_map_proj_party;
drop table tbl_hash_tag;
drop table tbl_map_party_tag;
drop table tbl_map_proj_tag;
drop table tbl_hash_area;
drop table tbl_map_area_tag;

create sequence seq_project;
create sequence seq_hash_tag;

-- 권한 테이블
create table tbl_role(
   name         varchar2(50) primary key,
   prior_name      varchar2(50)
);

-- 프로젝트(포스트,리플) 테이블
create table tbl_project (
    hier_id     varchar2(2000) primary key,
   obj_type   char NOT NULL, -- p(프로젝트, 포스트), r(리플)
    content      varchar2(2000),
   writer_id   varchar2(200),
    -- post만 가지고 있음
   board_id   number(10),
   proj_title   varchar2(200),
   likes   number(20) default 0
);

-- proj_info_id, introdution, motivation, motto, plan, creation, deadline, views, likes   
-- 프로젝트 부가정보
create table tbl_project_addinfo (
    proj_info_id varchar2(2000) primary key,
    introdution varchar2(2000),
    motivation varchar2(2000),
    motto       varchar2(2000),
    plan        varchar2(2000),
    creation  date  default sysdate,
    deadline    date
);

-- 파티 테이블
create table tbl_party (
    party_id      varchar2(200) primary key,
    party_pw      varchar2(200),
    name        varchar2(200),
    role_name  varchar2(200) default 'ROLE_USER',-- 권한
    enabled number(1) default 1
);

-- 파티 부가정보 테이블
create table tbl_party_addinfo (
    party_info_id  varchar2(2000) primary key,
    email       varchar2(200),
    phone_num   varchar2(200)
);

-- 프로젝트-파티 관계 테이블
create table tbl_map_proj_party (
    proj_id     varchar2(2000),
    party_id      varchar2(2000),
    party_type    char not null, -- o_owner, m_member
    join_state  varchar2(20) not null, --참여확정상태 : join  대기상태 : wait
    primary key (proj_id, party_id)
);

-- 게시판 테이블
create table tbl_board(
   id          number(10) primary key, 
   name      varchar2(200)
);

-- 해시태그 테이블
create table tbl_hash_tag(
   tag_id         number(10) primary key,
   tag_name      varchar2(200)
);
-- 해시태그 테이블 인덱싱
create index idx_hash_tag_name on tbl_hash_tag(tag_name);

-- 프로젝트-태그 관계 테이블
create table tbl_map_proj_tag (
   proj_id      varchar2(200),
   tag_id      number(10),
   primary key(proj_id, tag_id)
);

-- 파티-태그 관계 테이블
create table tbl_map_party_tag (
    party_id      varchar2(200),
   tag_id     number(10),
   primary key(party_id, tag_id)
);

-- 해시태그 지역 테이블
create table tbl_hash_area (
    tag_id        number(10),
    tag_area   varchar2(200)
);

-- Proj 지역과 해시태그 지역 매핑 테이블
create table tbl_map_area_tag (
    proj_id        varchar2(200),
    tag_id       number(10)
);
commit;