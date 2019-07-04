/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.50 : Database - rbacdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rbacdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rbacdb`;

/*Table structure for table `jrbac_login_user` */

DROP TABLE IF EXISTS `jrbac_login_user`;

CREATE TABLE `jrbac_login_user` (
  `id` varchar(32) NOT NULL COMMENT '用户id,uuid32位',
  `username` varchar(64) NOT NULL COMMENT '登录用户名',
  `password` varchar(32) NOT NULL COMMENT '登录密码,生成的password也是32位',
  `nickname` varchar(64) DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '用户修改时间,要用程序控制,ubuntu上不能设置为now()',
  `account_status` tinyint(4) DEFAULT '0' COMMENT '账户状态,默认为0,被锁定为1',
  `status` tinyint(4) DEFAULT '0' COMMENT '账户状态,默认为0,超级管理员1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jrbac_login_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录用户表';

/*Data for the table `jrbac_login_user` */

insert  into `jrbac_login_user`(`id`,`username`,`password`,`nickname`,`telephone`,`email`,`create_time`,`update_time`,`account_status`,`status`) values ('1','sa','123456','程同学','15353530000','peer44@qq.com','2016-10-26 13:57:04',NULL,0,0),('2','安美娇','123456','安老师','13501091476','123@qq.com','2018-01-01 00:00:00',NULL,0,0),('3','刘辉','123456','刘同学','13501091234','123@qq.com','2018-02-03 00:00:00',NULL,0,0),('4','张艳妹','123456','教务张','13403045678','456@qq.com','2019-01-01 00:00:00',NULL,0,0),('5','霍','123456','霍校长','13809763456','789@qq.com','2014-01-01 00:00:00',NULL,0,0),('6','钟婷','123456','钟班主任','13489072345','123@qq.com','2013-01-01 00:00:00',NULL,0,0);

/*Table structure for table `jrbac_menu` */

DROP TABLE IF EXISTS `jrbac_menu`;

CREATE TABLE `jrbac_menu` (
  `id` varchar(32) NOT NULL COMMENT '主键id,uuid32位',
  `name` varchar(64) NOT NULL COMMENT '登录用户名',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父菜单id',
  `url` varchar(64) DEFAULT NULL COMMENT '访问地址',
  `icon` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `order` tinyint(4) DEFAULT '0' COMMENT '菜单顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `jrbac_menu` */

insert  into `jrbac_menu`(`id`,`name`,`parent_id`,`url`,`icon`,`order`) values ('100','个人设置','','/admin/user/setting.html','fa fa-toggle-on',100),('64aff0215238445d9a8fe3c7ce2a0191','文件上传','fc6d3a8ee066437aa4f419e6d69dca3a','/admin/test/fileupload.html','',0),('90','系统管理','','','fa fa-wrench',90),('91','用户管理','90','/admin/user/index.html','',1),('92','角色管理','90','/admin/role/index.html',NULL,2),('93','菜单管理','90','/admin/menu/index.html',NULL,3),('94','学生管理','90',NULL,NULL,0),('bb46286b302b46b0aac42038600a2cdd','后台首页','','/admin/home/index.html','fa fa-home',0),('fc6d3a8ee066437aa4f419e6d69dca3a','测试页面','','','fa fa-file-text',10);

/*Table structure for table `jrbac_role` */

DROP TABLE IF EXISTS `jrbac_role`;

CREATE TABLE `jrbac_role` (
  `id` varchar(32) NOT NULL COMMENT '主键id,uuid32位',
  `name` varchar(64) NOT NULL COMMENT '角色名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '角色创建时间，主要是用来进行排序',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `jrbac_role` */

insert  into `jrbac_role`(`id`,`name`,`create_time`) values ('1','管理员','2018-01-01 00:00:00'),('2','校长','2018-01-01 00:00:00'),('3','教员','2018-10-01 00:00:00'),('4','班主任','2018-01-01 00:00:00'),('5','教务','2018-01-01 00:00:00'),('6','学生','2018-01-01 00:00:00');

/*Table structure for table `jrbac_role_menu` */

DROP TABLE IF EXISTS `jrbac_role_menu`;

CREATE TABLE `jrbac_role_menu` (
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `menu_id` varchar(32) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `role_id` (`role_id`),
  KEY `fk_menu_id` (`menu_id`),
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `jrbac_menu` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `jrbac_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

/*Data for the table `jrbac_role_menu` */

insert  into `jrbac_role_menu`(`role_id`,`menu_id`) values ('1','100'),('1','90'),('1','91'),('1','92'),('1','93'),('1','94'),('3','90'),('3','94'),('4','90'),('4','94');

/*Table structure for table `jrbac_user_role` */

DROP TABLE IF EXISTS `jrbac_user_role`;

CREATE TABLE `jrbac_user_role` (
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_id` (`user_id`),
  KEY `fk_role_id_user_role` (`role_id`),
  CONSTRAINT `fk_role_id_user_role` FOREIGN KEY (`role_id`) REFERENCES `jrbac_role` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jrbac_login_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `jrbac_user_role` */

insert  into `jrbac_user_role`(`user_id`,`role_id`) values ('1','1'),('2','3'),('3','6'),('4','5'),('5','2'),('6','4'),('6','5');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
