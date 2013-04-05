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

insert into category values(seq_ctg.nextval,'水果');
insert into category values(seq_ctg.nextval,'海鲜');
insert into category values(seq_ctg.nextval,'图书');

insert into goods values(seq_goodsno.nextval,'乌贼',7.2,3,'自营','冷藏','上架');
insert into goods values(seq_goodsno.nextval,'苹果',5.5,2,'厂家直销','保鲜薄膜','上架');
insert into goods values(seq_goodsno.nextval,'西红柿',2.2,2,'自产','保险剂','未上架');
insert into goods values(seq_goodsno.nextval,'带鱼',8.2,3,'厂家直销','冷藏','上架');
insert into goods values(seq_goodsno.nextval,'香蕉',5.4,2,'代售','保鲜薄膜','未上架');
insert into goods values(seq_goodsno.nextval,'葡萄',3.1,2,'厂家直销','保鲜薄膜','上架');
insert into goods values(seq_goodsno.nextval,'oracle学习',34.5,4,'代售','定期整理','上架');
insert into goods values(seq_goodsno.nextval,'J2EE学习',21,4,'代售','定期整理','未上架');
