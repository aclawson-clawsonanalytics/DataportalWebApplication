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
    private String email;
    private String password;
    private String status;
    private boolean isLoggedIn = false;
    
    public User(){
        super.setTablename("USERS");
        super.setID(0);
        setLogin(false);
        setStatus("Active");
        
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
    
    public void setEmail(String string){
        this.email = string;
    }
    
    public String getEmail(){
        return email;
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
    
    public void setLogin(boolean aBool){
        this.isLoggedIn = aBool;
    }
    
    public boolean getLoginStatus(){
        return this.isLoggedIn;
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
        if (email == null || email.equals("")){
            validationErrors.add("User must have email.");
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
        if (this.getID() == 0){
            
            String queryString = " INSERT INTO USERS (firstname,lastname,username,email,password,status,isLoggedIn)"
                    + "VALUES(?,?,?,?,?,?,?);";
            try {
                ConnectionManager manager = new ConnectionManager("PODUCTION");
                manager.preparedStatement = manager.connection.prepareStatement(queryString);
                manager.preparedStatement.setString(1, this.getFirstName());
                manager.preparedStatement.setString(2, this.getLastName());
                manager.preparedStatement.setString(3, this.getUsername());
                manager.preparedStatement.setString(4, this.getEmail());
                manager.preparedStatement.setString(5, this.getPassword());
                manager.preparedStatement.setString(6, this.getStatus());
                manager.preparedStatement.setBoolean(7, this.getLoginStatus());
                manager.preparedStatement.execute();
                manager.CloseResources();

            } catch (SQLException e) {
                e.printStackTrace();
                // Add more exception handling actions here.
            }
        }
    }
    @Override
    public void Save(String mode){
        if (this.getID() == 0){
            
            String queryString = " INSERT INTO USERS (firstname,lastname,username,email,password,status,isLoggedIn)"
                    + "VALUES(?,?,?,?,?,?,?);";
            try {
                ConnectionManager manager = new ConnectionManager(mode);
                manager.preparedStatement = manager.connection.prepareStatement(queryString);
                manager.preparedStatement.setString(1, this.getFirstName());
                manager.preparedStatement.setString(2, this.getLastName());
                manager.preparedStatement.setString(3, this.getUsername());
                manager.preparedStatement.setString(4, this.getEmail());
                manager.preparedStatement.setString(5, this.getPassword());
                manager.preparedStatement.setString(6, this.getStatus());
                manager.preparedStatement.setBoolean(7, this.getLoginStatus());
                manager.preparedStatement.execute();
                manager.CloseResources();

            } catch (SQLException e) {
                e.printStackTrace();
                // Add more exception handling actions here.
            }
        }
    }
    
    


    
}
