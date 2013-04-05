conn supershop05/abc123;

/*大类，小类*/
create table category(
	ctg_id int primary key,
	ctg_pid int ,
	ctg_name varchar(30) not null,
	ctg_linkurl varchar2(100),
	constraint FK_CTG_PARENT FOREIGN KEY (ctg_pid) references category(ctg_id)
);

/*商品*/
create table goods(
	goods_id int primary key,
 	goods_price number(9,2) not null,
	goods_name varchar2(30) not null,
 	goods_desc varchar2(100),
 	goods_pic blob,
 	goods_store char(1) not null,
 	goods_status char(1) not null,
 	goods_ctg int not null,
 	constraint FK_GOODS_CTG FOREIGN KEY (goods_ctg) references category(ctg_id)
);

/*用户*/
create table users(
	user_id int  primary key,
	user_name varchar2(30) not null,
 	user_pwd varchar2(30) not null,
	user_real_name varchar2(10) not null,
 	user_sex char(1) not null,
 	user_birthday date  not null,
 	user_email varchar2(30) unique,
	user_phone varchar2(30) not null,
 	user_addr varchar2(100) not null,
 	user_postcode char(6) not null,
 	user_status char(1) not null
);

/*管理员*/
create table admine_users(
 admine_id int  primary key,
 admine_name varchar2(30) not null,
 admine_pwd varchar2(30) not null,
 admine_real_name varchar2(10) not null,
 admine_sex char(1) not null,
 admine_birthday date  not null,
 admine_email varchar2(30) ,
 admine_phone varchar2(20) not null,
 admine_addr varchar2(100) not null,
 admine_postcode char(6) not null
);

/*订单表*/
create table orders(
  order_id int primary key,
  order_date date not null,
  order_status char(1) not null,
  order_sum number(9,2) not null,
  goods_quantity int not null, --商品数量
  goods_id int not null,  --商品ID
  user_id int not null,   --用户ID
  admine_id int not null, --管理员ID
  constraint FK_ORDER_USERS FOREIGN KEY (user_id) references users(user_id),
  constraint FK_ORDER_ADMIN FOREIGN KEY (admine_id) references admine_users(admine_id)
);

create  sequence seq_goods  
increment by 1
start with 1
nomaxvalue
nocycle;


create  sequence seq_users
increment by 1
start with 1
nomaxvalue
nocycle;

create  sequence seq_admine  
increment by 1
start with 1
nomaxvalue
nocycle;

create  sequence seq_order  
increment by 1
start with 10000
nomaxvalue
nocycle;