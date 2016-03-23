/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;
import java.util.ArrayList;
import java.sql.SQLException;
import Core.Database.SQLModel;
import Core.Database.ConnectionManager;

/**
 *
 * @author andrewclawson
 */
public class Student extends SQLModel {
    private static String tablename;
    private String firstname;
    private String lastname;
    private String gender;
    private int gradelevel;
    private int campusID;
    //private String firstname;
    
    public Student(){
        Student.setTablename("STUDENT");
    }
    
    public static void setTablename(String string){
        tablename = string;
    }
    
    public static String getTablename(){
        return tablename;
    }
    
    public void setFirstname(String string){
        firstname = string;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public void setLastname(String string){
        lastname = string;
    }
    
    public String getLastname(){
        return this.lastname;
    }
    
    public void setGender(String string){
        gender = string;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public void setGradeLevel(int grade){
        this.gradelevel = grade;
    }
    
    public int getGradelevel(){
        return this.gradelevel;
    }
    
    public void setCampus(int id){
        this.campusID = id;
    }
    
    public int getCampus(){
        return this.campusID;
    }
    
    @Override
    public void Save(String mode){
        if (this.getID() == 0){
            if (this.IsValid()){
                super.SetIDBySQL(mode, Student.getTablename());
                String sqlString = "INSERT INTO " + Student.getTablename() + " (firstname,"
                        + "lastname, gender, gradelevel, campus_id)"
                        + " VALUES(?,?,?,?,?)";
                ConnectionManager manager = new ConnectionManager(mode);
                try{
                    manager.preparedStatement = manager.connection.prepareStatement(sqlString);
                    manager.preparedStatement.setString(1,this.getFirstname());
                    manager.preparedStatement.setString(2,this.getLastname());
                    manager.preparedStatement.setString(3, this.getGender());
                    manager.preparedStatement.setInt(4, this.getGradelevel());
                    manager.preparedStatement.setInt(5, this.getCampus());
                    manager.preparedStatement.execute();
                    manager.CloseResources();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                
            }
        }
    }
    @Override
    public ArrayList<String> GetValidationErrors(){
        ArrayList<String> validationErrors = new ArrayList();
        if (this.getFirstname() == null || this.getFirstname() == ""){
            validationErrors.add("Student must have a firstname.");
        }
        if (this.getLastname() == null || this.getLastname() == ""){
            validationErrors.add("Student must have a lastname.");
        }
        
        if (this.getGender() == null || this.getGender() == ""){
            validationErrors.add("Student is missing a gender.");
        }else if (!this.getGender().equals("Male") && !this.getGender().equals("Female")){
            validationErrors.add("Gender must be Male or Female.");
        }
        
        if (this.getGradelevel() < 9 || this.getGradelevel() > 12){
            validationErrors.add("Grade level must be between 9 and 12.");
        }
        
        
        
        return validationErrors;
    }
}
