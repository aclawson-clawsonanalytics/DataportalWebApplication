/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoodcockJohnson.Models;
import Core.Database.ConnectionManager;
import Core.Database.SQLModel;
import Core.ModelLayer.Student;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;

import Core.Database.ConnectionManager;
import WoodcockJohnson.Reference.FormReference;

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
    
    public void setReferenceID(int id){
        this.referenceID = id;
    }
    
    public int getReferenceID(){
        return this.referenceID;
    }
    
    @Override
    public ArrayList<String> GetValidationErrors(){
        ArrayList<String> validationErrors = new ArrayList<String>();
        try{
            FormReference formReference = FormReference.GetReferenceByID(this.getReferenceID(),
                    BookletForm.getReferenceTablename());
            if (formReference == null){
                validationErrors.add("Invalid reference ID.");
            }
        }catch (NullPointerException e){
            validationErrors.add("Invalid reference ID.");
        }
        
        return validationErrors;
    }
    
    @Override
    public void Save(String mode){
        ConnectionManager manager = new ConnectionManager(mode);
        String sqlString = "INSERT INTO " + BookletForm.getTablename() + "(reference_id,student_id,assessmentDate)"
                + " VALUES (?,?,?)";
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sqlString);
            manager.preparedStatement.setInt(1,this.getReferenceID());
            manager.preparedStatement.setInt(2, this.getStudentID());
            manager.preparedStatement.setDate(3, this.getAssessmentDate());
            manager.preparedStatement.execute();
            manager.CloseResources();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    
}
