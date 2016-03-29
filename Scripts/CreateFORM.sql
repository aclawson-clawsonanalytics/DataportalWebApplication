/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andrewclawson
 * Created: Mar 27, 2016
 */

CREATE TABLE IF NOT EXISTS 'FORM'(
    'id' int(11) unsigned NOT NULL AUTO_INCREMENT,
    'reference_id' int(11) unsigned NOT NULL,
    'student_id' int(11) unsigned NOT NULL,
    'assessmentDate' date,
    PRIMARY KEY ('id'),
    KEY 'FormReference' (reference_id),
    KEY 'StudentReference' (student_id),
    CONSTRAINT 'FormReference' FOREIGN KEY ('reference_id') REFERENCES 'FormReference' ('id'),
    CONSTRAINT 'StudentReference' FOREIGN KEY ('student_id') REFERENCES 'STUDENT' ('id')
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
