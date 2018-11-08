/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.16 : Database - springbootdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springbootdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springbootdb`;

/*Table structure for table `blog_article` */

DROP TABLE IF EXISTS `blog_article`;

CREATE TABLE `blog_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT '0',
  `article_name` varchar(200) NOT NULL,
  `digest` varchar(2000) DEFAULT NULL COMMENT '文章摘要',
  `article_click` int(11) DEFAULT '0',
  `article_type` int(11) NOT NULL DEFAULT '1' COMMENT '文章的模式:0为私有，1为公开',
  `article_content` text NOT NULL,
  `article_up` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否置顶:0为否，1为是',
  `entry_id` int(11) DEFAULT NULL,
  `entry_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `blog_article` */

insert  into `blog_article`(`article_id`,`category_id`,`article_name`,`digest`,`article_click`,`article_type`,`article_content`,`article_up`,`entry_id`,`entry_datetime`) values (1,0,'金凤凰',NULL,0,1,'<p>This is my textarea to be replaced with CKEditor.</p>\n',0,NULL,'2018-05-02 22:31:39'),(2,0,'',NULL,0,1,'<p><strong>测试内容</strong></p>\n\n<hr />\n<p>正文</p>\n\n<p>图片<img alt=\"\" src=\"/blog/static/upload/1525317569917.jpg\" style=\"height:768px; width:1024px\" /></p>\n',0,NULL,'2018-05-03 11:19:37'),(3,0,'',NULL,0,1,'<p>This is my textarea to be replaced with CKEditor.<img alt=\"\" src=\"/blog/static/upload/1525326360826.jpg\" style=\"height:768px; width:1024px\" /></p>\n',0,NULL,'2018-05-03 13:46:39'),(4,0,'',NULL,0,1,'<p>This is my textarea to be replasdasdadadsaced with CKEditor.<img alt=\"\" src=\"/blog/static/upload/1525333151516.jpg\" style=\"height:768px; width:1024px\" /></p>\n',0,NULL,'2018-05-03 15:39:18'),(5,0,'',NULL,0,1,'<p>This is my textarea to be replasdasdadadsaced with CKEditor.<img alt=\"\" src=\"/blog/static/upload/1525333151516.jpg\" style=\"height:768px; width:1024px\" /></p>\n',0,NULL,'2018-05-03 16:04:25'),(6,0,'',NULL,0,1,'<p>This is my textarea to be replaced with CKEditor.<img alt=\"\" src=\"/blog/static/upload/1525334784699.jpg\" style=\"height:768px; width:1024px\" /></p>\n',0,NULL,'2018-05-03 16:06:29'),(7,0,'',NULL,0,1,'<p><img alt=\"\" src=\"D:/upload/1525336396551.jpg\" />This is my textarea to be replaced with CKEditor.</p>\n',0,NULL,'2018-05-03 16:33:21'),(8,2,'测试','啊啊啊啊',0,1,'<p>This is my textarea to be replaced with CKEditor.</p>\n',0,NULL,'2018-05-04 16:12:21');

/*Table structure for table `blog_article_category` */

DROP TABLE IF EXISTS `blog_article_category`;

CREATE TABLE `blog_article_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `blog_article_category` */

insert  into `blog_article_category`(`category_id`,`category_name`) values (1,'技术'),(2,'随记');

/*Table structure for table `blog_user` */

DROP TABLE IF EXISTS `blog_user`;

CREATE TABLE `blog_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `entry_datetime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `blog_user` */

insert  into `blog_user`(`id`,`name`,`age`,`password`,`entry_datetime`) values (2,'eason',24,'123456','2018-04-22 20:08:06');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
