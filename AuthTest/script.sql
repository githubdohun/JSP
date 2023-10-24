-- AuthTest > script.sql

drop table tblBoard;
drop table tblUser;

create table tblUseer (
    id varchar2(30) primary key,
    pw varchar2(30) not null,
    name varchar2(30) not null,
    lv number(1) not null
);

insert into tblUseer values ('hong', '1111', '홍길동', 1);
insert into tblUseer values ('test', '1111', '테스트', 1);
insert into tblUseer values ('admin', '1111', '관리자', 2);

commit;

select * from tblUseer where id ='aaa' and pw = '1234';
select * from tblUseer where id ='hong' and pw = '1111';



