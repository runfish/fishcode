create table category(
ctg_id int primary key,
ctg_name varchar2(20)not null
);
create table goods(
 goods_id int primary key,
 goods_name varchar2(20)not null,
 goods_price number(6,2)not null,
 goods_ctg_id int not null,
 goods_src varchar2(20)not null,
 goods_goods_store_condition varchar2(20)not null,
 goods_status varchar2(10)not null,
 constraint FK_GOODS_CTG_ID foreign key (goods_ctg_id) references category (ctg_id)
 );
create sequence seq_ctg;
create sequence seq_goodsno;

insert into category values(seq_ctg.nextval,'ˮ��');
insert into category values(seq_ctg.nextval,'����');
insert into category values(seq_ctg.nextval,'ͼ��');

insert into goods values(seq_goodsno.nextval,'����',7.2,3,'��Ӫ','���','�ϼ�');
insert into goods values(seq_goodsno.nextval,'ƻ��',5.5,2,'����ֱ��','���ʱ�Ĥ','�ϼ�');
insert into goods values(seq_goodsno.nextval,'������',2.2,2,'�Բ�','���ռ�','δ�ϼ�');
insert into goods values(seq_goodsno.nextval,'����',8.2,3,'����ֱ��','���','�ϼ�');
insert into goods values(seq_goodsno.nextval,'�㽶',5.4,2,'����','���ʱ�Ĥ','δ�ϼ�');
insert into goods values(seq_goodsno.nextval,'����',3.1,2,'����ֱ��','���ʱ�Ĥ','�ϼ�');
insert into goods values(seq_goodsno.nextval,'oracleѧϰ',34.5,4,'����','��������','�ϼ�');
insert into goods values(seq_goodsno.nextval,'J2EEѧϰ',21,4,'����','��������','δ�ϼ�');
