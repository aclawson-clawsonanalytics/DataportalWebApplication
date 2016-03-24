/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andrewclawson
 * Created: Mar 23, 2016
 */
USE DSS_Dataportal_Test;
CREATE TABLE IF NOT EXISTS FormReference (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  label varchar(1) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS AssessmentReference (
    testNumber int(2) unsigned NOT NULL,
    subject varchar(100) DEFAULT NULL,
    basal int(2) DEFAULT NULL,
    ceiling int(2) DEFAULT NULL,
    timeLimit int(2) DEFAULT NULL,
    form varchar(1) NOT NULL,
    PRIMARY KEY (testNumber)
)



