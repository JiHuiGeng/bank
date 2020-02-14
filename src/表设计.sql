use ssm;

#---银行账户表--
create table account(
id int(10) primary key auto_increment comment'编号',
accNo varchar(18) unique comment'账户',
password int(6) comment'密码',
balance decimal(10,2) comment'余额',
name varchar(20)
);

insert into account values(default,'1',123456,20000.00,'战三');
insert into account values(default,'2',123456,5000.00,'李四');

drop table account;
select * from account;


#--交易日志记录表--
create table log(
id int(10) primary key auto_increment comment'编号',
inAccNo varchar(18) comment'转入账户',
outAccNo varchar(18) comment'转出账户',
money decimal(10,2) comment'金额'
);
select * from log;

show processlist;







