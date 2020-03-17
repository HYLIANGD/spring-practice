USE `world`;

DROP TABLE IF EXISTS `level_authorities`;
DROP TABLE IF EXISTS `role_authorities`;
DROP TABLE IF EXISTS `my_users`;

CREATE TABLE `my_users`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`theusername` varchar(20) NOT NULL UNIQUE,
`thepassword` varchar(68) NOT NULL,
PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `level_authorities`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`userid` int(11) NOT NULL,
`thelevel` varchar(20) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `level_authorities_fk` FOREIGN KEY (`userid`) REFERENCES `my_users` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `role_authorities`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`userid` int(11) NOT NULL,
`therole` varchar(20) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `role_authorities_fk` FOREIGN KEY (`userid`) REFERENCES `my_users` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `my_users` VALUES
(1, 'john', '123'),
(2, 'tim', '123'),
(3, 'ray', '123'),
(4, 'dad', '123');

INSERT INTO `level_authorities` VALUES
(1,1,'LEVEL_A'),
(2,1,'LEVEL_B'),
(3,1,'LEVEL_C'),
(4,2,'LEVEL_B'),
(5,2,'LEVEL_C'),
(6,3,'LEVEL_C'),
(7,4,'LEVEL_A'),
(8,4,'LEVEL_B'),
(9,4,'LEVEL_C');

INSERT INTO `role_authorities` VALUES
(1,1,'ROLE_STAFF'),
(2,2,'ROLE_USER'),
(3,3,'ROLE_USER'),
(4,4,'ROLE_MANAGER');

