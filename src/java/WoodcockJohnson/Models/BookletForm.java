/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoodcockJohnson.Models;
import Core.Database.ConnectionManager;
import Core.Database.SQLModel;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.sql.Date;


/**
 *
 * @author andrewclawson
 */
public class BookletForm extends SQLModel {
    private static String tablename;
    private static String referenceTablename;
    private int ID; //Unique id for model object. This will be unique for each booklet administered.
    private int referenceID; //Link to the form reference in the FormReference database table. (Foreign key)
    private int studentID; //Reference to the corresponding studentid. (Foreign key relationship)
    private Date assessmentDate;
    
    public BookletForm(){
        setTablename("Form");
        referenceTablename = "FormReference";
        super.setID(0);
    }
    
    public static void setTablename(String string){
        tablename = string;
    }
    
    public static String getTablename(){
        return tablename;
    }
    
    public static void setReferenceTablename(String string){
        tablename = string;
    }
    
    public static String getReferenceTablename(){
        return referenceTablename;
    }
    
    public void setStudentID(int id){
        studentID = id;
    }
    
    public int getStudentID(){
        return this.studentID;
    }
    
    public void setAssessmentDate(Date date){
        this.assessmentDate = date;
    }
    
    public Date getAssessmentDate(){
        return this.assessmentDate;
    }
    
}
