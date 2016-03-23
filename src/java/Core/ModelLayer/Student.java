/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;
import java.util.ArrayList;
import Core.Database.SQLModel;

/**
 *
 * @author andrewclawson
 */
public class Student extends SQLModel {
    private static String tablename;
    private String firstname;
    private String lastname;
    private String gender;
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
        }
        if (!this.getGender().equals("Male") && !this.getGender().equals("Female")){
            validationErrors.add("Gender must be Male or Female.");
        }
        
        return validationErrors;
    }
}
