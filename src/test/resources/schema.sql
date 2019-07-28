DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id`  int(11) NOT NULL AUTO_INCREMENT,
`name`  varchar(32) NOT NULL ,
`password`  varchar(32) NOT NULL ,
`account` varchar (32) NOT  NULL ,
`age`  int(11) NULL ,
`birth`  datetime NULL ,
`role`  int(11) NOT NULL ,
`school`  varchar(64) NULL ,
`email`  varchar(64) NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
`id`  int(11) NOT NULL AUTO_INCREMENT,
`account`  varchar(32) NOT NULL ,
`province`  varchar(32) NULL ,
`city`  varchar(32) NULL ,
`county`  varchar(32) NULL ,
`address_name`  varchar(64) NULL ,
`address`  varchar(128) NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;