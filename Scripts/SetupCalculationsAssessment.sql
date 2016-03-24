/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andrewclawson
 * Created: Mar 23, 2016
 */

USE DSS_Dataportal;
INSERT INTO AssessmentReference (testNumber,subject,basal,ceiling,timeLimit,form_id)
VALUES (5,"Calculation",6,6,0,1);

INSERT INTO AssessmentReference (testNumber,subject,basal,ceiling,timeLimit,form_id)
VALUES (5,"Calculation",6,6,0,2);

USE DSS_Dataportal_Test;
INSERT INTO AssessmentReference (testNumber,subject,basal,ceiling,timeLimit,form_id)
VALUES (5,"Calculation",6,6,0,1);

INSERT INTO AssessmentReference (testNumber,subject,basal,ceiling,timeLimit,form_id)
VALUES (5,"Calculation",6,6,0,2);

