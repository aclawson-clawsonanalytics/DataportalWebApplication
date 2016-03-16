/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andrewclawson
 * Created: Mar 15, 2016
 */

USE DSS_Dataportal;
CREATE TABLE CAMPUS(
id int unsigned NOT NULL,
name VARCHAR(100),
school_id int unsigned,
PRIMARY KEY (id),
FOREIGN KEY (school_id) REFERENCES SCHOOLS(school_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

USE DSS_Dataportal_Test;
CREATE TABLE CAMPUS(
id int unsigned NOT NULL,
name VARCHAR(100),
school_id int unsigned,
PRIMARY KEY (id),
FOREIGN KEY (school_id) REFERENCES SCHOOLS(school_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
