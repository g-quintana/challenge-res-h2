DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `owner_id_fk` int(11) NOT NULL,
  `creation_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `modification_date` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `state` varchar(45) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `currency` varchar(45) NOT NULL,
  `active` boolean DEFAULT 1,
  PRIMARY KEY (`id`)
);

--
-- Data for table `item`
--

INSERT INTO `item` VALUES 
	(1,'Lapiceras','BIC',1,DEFAULT,DEFAULT,'PUBLISHED',123.45,'ARS',1),
	(2,'Lamparas','Phillips',1,DEFAULT,DEFAULT,'PUBLISHED',600,'ARS',1),
	(3,'Parlantes','Phillips',1,DEFAULT,DEFAULT,'PUBLISHED',6500,'ARS',1),
	(4,'Monitor','Samsung',1,DEFAULT,DEFAULT,'PUBLISHED',20000,'ARS',1),
	(5,'Mouse','Genius',1,DEFAULT,DEFAULT,'PAUSED',3500,'ARS',1);

