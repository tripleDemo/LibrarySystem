/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.40 : Database - librarydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`librarydb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `librarydb`;

/*Table structure for table `authormsg` */

DROP TABLE IF EXISTS `authormsg`;

CREATE TABLE `authormsg` (
  `authorId` int(11) NOT NULL AUTO_INCREMENT,
  `authorName` varchar(20) NOT NULL,
  `authorPhoto` varchar(80) DEFAULT NULL,
  `authorBirth` date DEFAULT NULL,
  PRIMARY KEY (`authorId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `authormsg` */

insert  into `authormsg`(`authorId`,`authorName`,`authorPhoto`,`authorBirth`) values (1,'Torvalds','/ssm/static/images/authors/author1.png','1969-12-28'),(2,'Korotkevich','/ssm/static/images/authors/author2.png','1994-09-25'),(3,'Dean','/ssm/static/images/authors/author3.png','1968-06-01'),(4,'Stallman','/ssm/static/images/authors/author4.png','1953-03-16'),(5,'FabriceBellard','/ssm/static/images/authors/author5.png','1972-01-01'),(6,'Knuth','/ssm/static/images/authors/author6.png','1938-01-10'),(7,'Hejlsberg','/ssm/static/images/authors/author7.png','1960-12-12'),(8,'Thompson','/ssm/static/images/authors/author8.png','1943-02-04'),(9,'Angelo','/ssm/static/images/authors/author9.png','1989-07-21'),(10,'Cutting','/ssm/static/images/authors/author10.png','1979-12-24'),(13,'蒂姆','/ssm/static/images/authors/398c3ce3-ffdb-4b08-9833-aee5954b04cf6-20_194550.png','1966-08-08');

/*Table structure for table `bookmsg` */

DROP TABLE IF EXISTS `bookmsg`;

CREATE TABLE `bookmsg` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(45) NOT NULL,
  `bookCover` varchar(80) DEFAULT NULL,
  `borrowNum` int(11) DEFAULT '0',
  `authorId` int(11) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `publishTime` date NOT NULL,
  PRIMARY KEY (`bookId`),
  KEY `FK_author_book` (`authorId`),
  CONSTRAINT `FK_author_book` FOREIGN KEY (`authorId`) REFERENCES `authormsg` (`authorId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `bookmsg` */

insert  into `bookmsg`(`bookId`,`bookName`,`bookCover`,`borrowNum`,`authorId`,`publisher`,`publishTime`) values (1,'黑客攻防从入门到精通','/ssm/static/images/books/book1.png',777,8,'机械工业出版社','2014-08-01'),(3,'Go语言编程基础','/ssm/static/images/books/book3.png',24,3,'人民邮电出版社','2015-11-20'),(4,'C++多线程编程实战','/ssm/static/images/books/book4.png',11,2,'人民邮电出版社','2018-06-09'),(5,'代码整洁之道','/ssm/static/images/books/book5.png',33,9,'人民邮电出版社','2014-08-22'),(6,'Python游戏编程入门','/ssm/static/images/books/book6.png',303,1,'人民邮电出版社','2018-11-09'),(7,'神经网络算法与实现','/ssm/static/images/books/book7.png',10,1,'人民邮电出版社','2016-05-26'),(8,'我的第一本编程书','/ssm/static/images/books/book8.png',6,7,'人民邮电出版社','2016-06-06'),(9,'蓝图可视化编程','/ssm/static/images/books/book9.png',12,5,'人民邮电出版社','2015-08-09'),(10,'Windows系统编程','/ssm/static/images/books/book10.png',21,5,'机械工业出版社','2017-09-09'),(11,'Windows汇编语言程序设计教程','/ssm/static/images/books/book11.png',36,3,'电子工业出版社','2016-08-25'),(12,'Python数据分析基础','/ssm/static/images/books/book12.png',490,2,'中国统计出版社','2018-09-23'),(13,'jQuery基础教程','/ssm/static/images/books/book13.png',655,4,'人民邮电出版社','2016-12-12'),(14,'Linux内核分析及编程','/ssm/static/images/books/book14.png',201,1,'电子工业出版社','2016-03-09'),(15,'C#程序设计及应用教程','/ssm/static/images/books/book15.png',33,7,'人民邮电出版社','2015-09-08'),(16,'Python趣味编程10例','/ssm/static/images/books/book16.png',25,8,'人民邮电出版社','2017-12-01'),(17,'Python基础教程','/ssm/static/images/books/book17.png',667,9,'人民邮电出版社','2018-01-01'),(18,'PHP专业项目实例开发','/ssm/static/images/books/book18.png',789,7,'中国水利水电出版社','2017-09-08'),(19,'Linux命令、编辑器与Shell编程','/ssm/static/images/books/book19.png',4,8,'清华大学出版社','2016-07-25'),(20,'JavaScript DOM编程艺术','/ssm/static/images/books/book20.png',24,9,'人民邮电出版社','2018-08-08'),(21,'Python深度学习','/ssm/static/images/books/book21.png',20,4,'人民邮电出版社','2019-01-01'),(22,'Python神经网络编程','/ssm/static/images/books/book22.png',7,1,'人民邮电出版社','2017-01-01'),(23,'Python编程入门','/ssm/static/images/books/book23.png',503,5,'人民邮电出版社','2016-03-03'),(24,'Python程序设计','/ssm/static/images/books/book24.png',891,5,'机械工业出版社','2018-02-02'),(25,'Python编程基础与HTTP接口测试','/ssm/static/images/books/book25.png',437,3,'电子工业出版社','2019-02-02'),(27,'java程序设计案例教程','/ssm/static/images/books/5e38c9ca-e65e-4cb9-8013-b667bf5bae69.png',0,13,'机械工业出版社','2015-08-08');

/*Table structure for table `borrowinfo` */

DROP TABLE IF EXISTS `borrowinfo`;

CREATE TABLE `borrowinfo` (
  `infoId` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) NOT NULL,
  `lendTime` date DEFAULT NULL,
  `returnTime` date DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`infoId`),
  KEY `FK_user_borrow` (`userId`),
  KEY `FK_book_borrow` (`bookId`),
  CONSTRAINT `FK_book_borrow` FOREIGN KEY (`bookId`) REFERENCES `bookmsg` (`bookId`),
  CONSTRAINT `FK_user_borrow` FOREIGN KEY (`userId`) REFERENCES `usermsg` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Data for the table `borrowinfo` */

insert  into `borrowinfo`(`infoId`,`bookId`,`lendTime`,`returnTime`,`userId`) values (12,9,'2019-06-16',NULL,8),(18,19,'2019-06-16','2019-06-18',8),(20,20,'2019-06-16',NULL,8),(21,16,'2019-06-16','2019-06-18',8),(26,18,'2019-06-16',NULL,8),(28,9,'2019-06-16',NULL,8),(31,3,'2019-06-17',NULL,8),(35,9,'2019-06-17',NULL,8),(37,25,'2019-06-17',NULL,8),(38,23,'2019-06-17',NULL,8),(54,4,'2019-06-21',NULL,8),(55,3,'2019-06-21',NULL,8),(56,9,'2019-06-21',NULL,8),(57,25,'2019-06-21',NULL,8),(58,3,'2019-06-21',NULL,8),(59,11,'2019-06-21',NULL,8);

/*Table structure for table `usermsg` */

DROP TABLE IF EXISTS `usermsg`;

CREATE TABLE `usermsg` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL COMMENT '用户名unique约束',
  `password` varchar(20) NOT NULL,
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0是用户，1是管理员',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `usermsg` */

insert  into `usermsg`(`userId`,`userName`,`password`,`type`) values (1,'admin','123456',1),(2,'jenny','123456',0),(3,'gogo','123456',0),(6,'tom','123456',0),(7,'sary','123456',0),(8,'荒城浪子','123456',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
