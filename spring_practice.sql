CREATE DATABASE IF NOT EXISTS `springpracticedb`;
USE `springpracticedb`;

DROP TABLE IF EXISTS `motos`;


CREATE TABLE `motos`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`brand` varchar(45) default null,
`modelname` varchar(45) default null,
`displacement` int(4) default null,
`insurance_id` int(11) default null,
`trackrecord` varchar(45) default null,
`certificationlevel` varchar(45) default null,
`trunk` int(3) default null,
PRIMARY KEY (`id`)
-- CONSTRAINT `insurance_ibfk_1` FOREIGN KEY (`insurance_id`) REFERENCES `insurance` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `motos` VALUES
(1,'YAMAHA','Cygnus',125,1,null,null,30),
(2,'YAMAHA','RX',110,1,null,null,20),
(3,'YAMAHA','Woo',100,1,null,null,10),
(4,'YAMAHA','R1',999,2,null,null,null),
(5,'YAMAHA','M1',999,2,'3M','A',null);