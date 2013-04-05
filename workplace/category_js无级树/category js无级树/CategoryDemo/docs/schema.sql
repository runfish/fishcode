create user hotelmgr identified by abc;
grant connect,resource to hotelmgr;

conn hotelmgr/abc;

create table category(
   ctg_id  int primary key,
   ctg_pid int , --�������
   ctg_name varchar2(30) not null,
   ctg_linkurl varchar2(100),
   constraint FK_CTG_PARENT FOREIGN KEY (ctg_pid) references category(ctg_id)
);


create sequence seq_ctgid;

example:
1   0   ���õ���  http://www.163.com 
2   1   ��������  http://www.csdn.net