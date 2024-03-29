
/*Data for the table `CM_MA_COURSE` */	
CREATE TABLE `CM_MA_COURSE` (
  `COURSE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `OPRTNL_FLAG` char(1) DEFAULT 'A',
  `CREATED_BY` int(11) NOT NULL,
  `CREATED_DATE` DATE NOT NULL,
  `MODIFIED_BY` int(11) NOT NULL,
  `MODIFIED_DATE` DATE NOT NULL,
  PRIMARY KEY (`COURSE_ID`),
  UNIQUE KEY `comp_set_set_name_uq` (`COURSE_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `CM_MA_COURSE` */

insert  into `CM_MA_COURSE`(`COURSE_ID`,`COURSE_NAME`,`DESCRIPTION`,`OPRTNL_FLAG`,`CREATED_BY`,`CREATED_DATE`,`MODIFIED_BY`,`MODIFIED_DATE`) values 
(1,'Core Java','Core Java','A',1,'2014-11-25',1,'2014-11-25'),
(2,'Servlets','Servlets','A',1,'2014-11-25',1,'2014-11-25');


DROP TABLE IF EXISTS `CM_MA_COURSE_MODULE`;

CREATE TABLE `CM_MA_COURSE_MODULE` (
  `COURSE_MODULE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_ID` int(11) NOT NULL,
  `MODULE_NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `RANK` int(11) DEFAULT NULL,
  `OPRTNL_FLAG` char(1) DEFAULT 'A',
  `CREATED_BY` int(11) NOT NULL,
  `CREATED_DATE` DATE NOT NULL,
  `MODIFIED_BY` int(11) NOT NULL,
  `MODIFIED_DATE` DATE NOT NULL,
  PRIMARY KEY (`COURSE_MODULE_ID`),
  UNIQUE KEY `comp_cname_uq` (`MODULE_NAME`),
  KEY `COURSE_CID_FK` (`COURSE_ID`),
  CONSTRAINT `COURSE_CID_FK` FOREIGN KEY (`COURSE_ID`) REFERENCES `CM_MA_COURSE` (`COURSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

/*Data for the table `CM_MA_COURSE_MODULE` */

