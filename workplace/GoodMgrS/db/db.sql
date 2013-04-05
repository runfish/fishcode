create user gxuser identified by gxpwd;

grant connect,resource to gxuser;

conn gxuser/gxpwd;

/*大类*/
create table big_category(
 b_ctg_id int primary key,
 b_ctg_name varchar2(30) unique not null,
 b_ctg_status char(1) not null

)

/*小类*/
create table small_category(
 s_ctg_id int primary key,
 s_ctg_name varchar2(30) unique not null,
 s_ctg_status char(1) not null,
 b_ctg_id int not null,
 constraint FK_SMALL_BIG foreign key (b_ctg_id) references big_category(b_ctg_id)
)
create sequence seq_small_ctgid;

/*商品*/
create table goods(
 goods_price number(8,2) not null,
 goods_id int primary key,
 goods_name varchar2(15) unique not null,
 goods_desc varchar2(150),
 goods_pic blob,
 goods_store char(1) not null,
 goods_status char(1)not null,
 goods_ctg int not null,
 constraint FK_GOODS_CTG foreign key (goods_ctg) references small_category(s_ctg_id)
)

/*用户*/
create table users(
 user_id int  auto_increment primaty key,--设置一个自增长的序列作为用户主键
 user_name varchar2(15) not null,
 user_pwd varchar2(15) not null,
 user_real_name varchar2(10) not null,
 user_sex char(1) not null,
 user_birthday date  not null,
 user_email varchar2(20) unique,--主键
 user_phone varchar2(20) not null,
 user_addr varchar2(100) not null,
 user_postcode char(6) not null,
 user_statue char(1) not null
)

/*订单*/
create table order_info(
 order_id int primary key,
 order_time date not null,
 order_amount number(8,2) not null,
 pay_mode char(1) not null,
 receive_mode char(1) not null,
 receiver_name varchar2(10) not null,
 receiver_addr varchar2(100) not null,
 receiver_postcode char(6) not null,
 receiver_phone varchar2(20) not null,
 receiver_email varchar2(20) not null,
 order_status char(1) not null,
 user_email varchar2(20) not null,--外键
 constraints FK_ORDER_USERS foreign key (user_email) references users(user_email)
)

/*订单条目*/
create table order_item(
 item_id int primary key,
 item_amount int not null,
 item_goods_price number(8,2) not null,
 goods_id int not null,
 order_id int not null,
 constraint FK_ITEM_GOODS FOREIGN KEY (goods_id) references goods(goods_id),
 constraint FK_ITEM_ORDER FOREIGN KEY(order_id)  references order_info(order_id)
)
/*管理员*/
create table admine_users(
 admine_id int  auto_increment primaty key,--设置一个自增长的序列作为用户主键
 admine_name varchar2(15) not null,
 admine_pwd varchar2(15) not null,
 admine_real_name varchar2(10) not null,
 admine_sex char(1) not null,
 admine_birthday date  not null,
 admine_email varchar2(20) ,--主键
 admine_phone varchar2(20) not null,
 admine_addr varchar2(100) not null,
 admine_postcode char(6) not null
 
)