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
import Core.Database.ConnectionManager;
import java.sql.SQLException;

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
        this.setStatus("Active");
        
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
    
    public void setStatus(String string){
        this.status = string;
    }
    
    public String getStatus(){
        return this.status;
    }
    public String getTablename(){
        return super.getTablename();
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
    /*
    @Override
    public void Save(){
        try{
            ConnectionManager manager = new ConnectionManager();
            String insertString = "INSERT INTO Contact ";
            String idString = "'" + Integer.toString(this.GetID()) + "',";
            String firstString = "'"+ this.getFirstName() + "',";
            String lastString = "'" + this.getLastName() + "',";
            String usernameString = "'" + this.getUsername() + "',";
            String statusString = "'" + this.getStatus() + "',";
        } catch(SQLException e){
            
        }
    }
*/
    
}
