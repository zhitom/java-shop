drop table shop_sale_def;
CREATE TABLE shop_sale_def
(
    shop_id           INT(10) UNSIGNED NOT NULL,
	shop_sale_id      INT(10) UNSIGNED NOT NULL,
	shop_sale_inst_id INT(10) UNSIGNED NOT NULL,
	max_money         INT(10) UNSIGNED ZEROFILL NOT NULL DEFAULT '0',
	user_limit_money  INT(10) UNSIGNED ZEROFILL NOT NULL DEFAULT '0',
	sale_mode         INT(1) NOT NULL DEFAULT '1',
	begin_time        timestamp  NOT NULL,
	end_time          timestamp  NOT NULL,
	PRIMARY KEY (shop_id,shop_sale_id,shop_sale_inst_id)
)engine=MYISAM default charset=utf8 ;

drop table shop_sale_result;
CREATE TABLE shop_sale_result
(
	shop_id           INT(10) UNSIGNED NOT NULL,
	shop_sale_id      INT(10) UNSIGNED NOT NULL,
	shop_sale_inst_id INT(10) UNSIGNED NOT NULL,
	max_money         INT(10) UNSIGNED ZEROFILL NOT NULL DEFAULT '0',
	user_limit_money  INT(10) UNSIGNED ZEROFILL NOT NULL DEFAULT '0',
	used_money        INT(10) UNSIGNED ZEROFILL NOT NULL DEFAULT '0',
	update_time       timestamp  NOT NULL,
	PRIMARY KEY (shop_id,shop_sale_id,shop_sale_inst_id)
)engine=MYISAM default charset=utf8 ;

drop table shop_sale_result_detail;
CREATE TABLE shop_sale_result_detail
(
	user_id           INT(10) UNSIGNED NOT NULL,
	shop_id           INT(10) UNSIGNED NOT NULL,
	shop_sale_id      INT(10) UNSIGNED NOT NULL,
	shop_sale_inst_id INT(10) UNSIGNED NOT NULL,
	present_money     INT(10) UNSIGNED NOT NULL,
	present_time      timestamp NOT NULL,
	apply_time        timestamp NOT NULL,
	PRIMARY KEY (user_id,shop_id,shop_sale_id,shop_sale_inst_id)
)engine=MYISAM default charset=utf8 ;

--样例数据插入
truncate table shop_sale_def;
truncate table shop_sale_result;
truncate table shop_sale_result_detail;
select * from shop_sale_def ;
insert into shop_sale_def (shop_id,shop_sale_id,shop_sale_inst_id,max_money,user_limit_money,sale_mode,begin_time,end_time)
  VALUES (561,10,0,100000000,0,1,'2014-11-11 12:00:00',timestamp('2014-11-11 12:00:00','1:00:00'));
insert into shop_sale_def (shop_id,shop_sale_id,shop_sale_inst_id,max_money,user_limit_money,sale_mode,begin_time,end_time)
  VALUES (561,20,1,100000000,0,1,'2015-11-11 12:00:00',timestamp('2015-11-11 12:00:00','1:00:00'));
insert into shop_sale_def (shop_id,shop_sale_id,shop_sale_inst_id,max_money,user_limit_money,sale_mode,begin_time,end_time)
  VALUES (561,20,2,100000000,100,1,'2016-03-11 12:00:00',timestamp('2016-03-11 12:00:00','1:00:00'));
commit;

