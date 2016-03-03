/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;
import java.util.List;
import java.util.ArrayList;
import Core.ModelLayer.IValidatable;
import Core.Database.SQLModel;
import Core.Database.ConnectionManager;
import Core.Database.ISQLInterface;
/**
 *
 * @author andrewclawson
 */
public class User extends SQLModel {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String status;
    private boolean isLoggedIn;
    
    public User(){
        super.setTablename("USERS");
        super.SetID();
        
    }
    public void setFirstName(String string){
        this.firstname = string;
    }
    
    public String getFirstName(){
        return firstname;
    }
    
    public void setLastName(String string){
        this.lastname = string;
    }
    
    public String getLastName(){
        return lastname;
    }
    
    public void setUsername(){
        this.username = firstname.toLowerCase().charAt(0) + lastname.toLowerCase();
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String string){
        this.password = string;
    }
    
    public String getTablename(){
        return super.getTablename();
    }
    
    public static User GetByID(int id){
        
    }
    
    @Override
    public ArrayList<String> GetValidationErrors(){
        ArrayList<String> validationErrors = new ArrayList();
        if (firstname == null || firstname.equals("")){
            validationErrors.add("User must have first name.");
        }
        if (lastname == null || lastname.equals("")){
            validationErrors.add("User nust have last name.");
        }
        return validationErrors;
    }
    
    @Override
    public boolean IsValid(){
        if (!GetValidationErrors().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void Save(){
        
    }
    
}
