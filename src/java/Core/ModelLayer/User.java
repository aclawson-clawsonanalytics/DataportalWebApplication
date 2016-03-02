/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;
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
    private String loginStatus;
    
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
    
    @Override
    public void Save(){
        
    }
    
}
