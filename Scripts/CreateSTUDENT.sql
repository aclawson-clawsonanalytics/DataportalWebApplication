/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andrewclawson
 * Created: Mar 22, 2016
 */

CREATE TABLE `STUDENT` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `gradelevel` int(2) DEFAULT NULL,
  `campus_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ParentCampus` (`campus_id`),
  CONSTRAINT `ParentCampus` FOREIGN KEY (`campus_id`) REFERENCES `CAMPUS` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
