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
    private static String tablename;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String status;
    private boolean isLoggedIn = false;
    
    public User(){
        setTablename("USERS");
        super.setID(0);
        setLogin(false);
        setStatus("Active");
        
    }
    
    
    public static String getTablename(){
        return tablename;
    }
    
    
    public static void setTablename(String string){
        tablename = string;
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
        if (GetValidationErrors().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public void Save(){
        if (this.getID() == 0){
            if (this.IsValid()){
                String queryString = "INSERT INTO USERS (firstname,lastname,username,email,password,status,isLoggedIn)"
                    + "VALUES(?,?,?,?,?,?,?);";
                try {
                    ConnectionManager manager = new ConnectionManager("PRODUCTION");
                    manager.preparedStatement = manager.connection.prepareStatement(queryString);
                    manager.preparedStatement.setString(1, this.getFirstName());
                    manager.preparedStatement.setString(2, this.getLastName());
                    manager.preparedStatement.setString(3, this.getUsername());
                    manager.preparedStatement.setString(4, this.getEmail());
                    manager.preparedStatement.setString(5, this.getPassword());
                    manager.preparedStatement.setString(6, this.getStatus());
                    if (this.getLoginStatus() == false){
                        manager.preparedStatement.setInt(7, 0);
                    }else{
                        manager.preparedStatement.setInt(7,1);
                    }
                    manager.preparedStatement.execute();
                    manager.CloseResources();

                } catch (SQLException e) {
                    e.printStackTrace();
                // Add more exception handling actions here.
                }
            }
            
        }
    }
    @Override
    public void Save(String mode){
        if (this.getID() == 0){
            if (this.IsValid()){
                super.SetIDBySQL("TEST_MODE", User.getTablename());
                String queryString = "INSERT INTO USERS (firstname,lastname,username,email,password,status,isLoggedIn)"
                        + "VALUES(?,?,?,?,?,?,?)";
                try {
                    ConnectionManager manager = new ConnectionManager(mode);
                    manager.preparedStatement = manager.connection.prepareStatement(queryString);
                    manager.preparedStatement.setString(1, this.getFirstName());
                    manager.preparedStatement.setString(2, this.getLastName());
                    manager.preparedStatement.setString(3, this.getUsername());
                    manager.preparedStatement.setString(4, this.getEmail());
                    manager.preparedStatement.setString(5, this.getPassword());
                    manager.preparedStatement.setString(6, this.getStatus());
                    if (this.getLoginStatus() == false){
                        manager.preparedStatement.setInt(7, 0);
                    }else{
                        manager.preparedStatement.setInt(7, 1);
                    }
                    manager.preparedStatement.execute();
                    manager.CloseResources();

                } catch (SQLException e) {
                    e.printStackTrace();
                    // Add more exception handling actions here.
                }
            } // Add response for invalid user
        } else{
            // Add case for existing user
            if (this.IsValid()){
                String sqlString = "UPDATE USERS SET firstname = ?,"
                        + "lastname = ?, "
                        + "username = ?, "
                        + "email = ?, "
                        + "password = ?, "
                        + "status = ?, "
                        + "isLoggedIn = ?"
                        + " WHERE id = ?";
                        
                try{
                    ConnectionManager manager = new ConnectionManager(mode);
                    manager.preparedStatement = manager.connection.prepareStatement(sqlString);
                    manager.preparedStatement.setString(1,this.getFirstName());
                    manager.preparedStatement.setString(2,this.getLastName());
                    manager.preparedStatement.setString(3,this.getUsername());
                    manager.preparedStatement.setString(4,this.getEmail());
                    manager.preparedStatement.setString(5,this.getPassword());
                    manager.preparedStatement.setString(6,this.getStatus());
                    if (this.getLoginStatus() == false){
                        manager.preparedStatement.setInt(7,0);
                    }else{
                        manager.preparedStatement.setInt(7, 1);
                    }
                    manager.preparedStatement.setInt(8, this.GetID());
                    System.out.println(sqlString);
                    manager.preparedStatement.executeUpdate();
                    //System.out.println(sqlString);
                    manager.CloseResources();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            
        }
    }
    
    public void Update(String mode){
        if (this.getID() != 0){
            if (this.IsValid()){
                String sqlString = "UPDATE USERS SET firstname = ?,"
                        + "lastname = ?, "
                        + "username = ?, "
                        + "email = ?, "
                        + "password = ?, "
                        + "status = ?, "
                        + "isLoggedIn = ?"
                        + " WHERE id = ?";
                        
                try{
                    ConnectionManager manager = new ConnectionManager(mode);
                    manager.preparedStatement = manager.connection.prepareStatement(sqlString);
                    manager.preparedStatement.setString(1,this.getFirstName());
                    manager.preparedStatement.setString(2,this.getLastName());
                    manager.preparedStatement.setString(3,this.getUsername());
                    manager.preparedStatement.setString(4,this.getEmail());
                    manager.preparedStatement.setString(5,this.getPassword());
                    manager.preparedStatement.setString(6,this.getStatus());
                    if (this.getLoginStatus() == false){
                        manager.preparedStatement.setInt(7,0);
                    }else{
                        manager.preparedStatement.setInt(7, 1);
                    }
                    manager.preparedStatement.setInt(8, this.GetID());
                    //System.out.println(sqlString);
                    manager.preparedStatement.executeUpdate();
                    //System.out.println(sqlString);
                    manager.CloseResources();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static ArrayList GetAll(String mode){
        ArrayList<User> allUsers = new ArrayList();
        ConnectionManager manager = new ConnectionManager(mode);
        String sqlStatement = "SELECT * FROM " + User.getTablename();
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sqlStatement);
            manager.resultSet = manager.preparedStatement.executeQuery();
            while(manager.resultSet.next()){
               User newUser = new User();
               newUser.setID(manager.resultSet.getInt("id"));
               newUser.setFirstName(manager.resultSet.getString("firstname"));
               newUser.setLastName(manager.resultSet.getString("lastname"));
               newUser.setEmail(manager.resultSet.getString("email"));
               newUser.setPassword(manager.resultSet.getString("password"));
               newUser.setStatus(manager.resultSet.getString("status"));
               if (manager.resultSet.getInt("isLoggedIn") == 0){
                   newUser.setLogin(false);
               } else{
                   newUser.setLogin(true);
               }
               allUsers.add(newUser);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allUsers;
    }
    
    public static User GetByID(int id, String mode){
        User user = new User();
        ConnectionManager manager = new ConnectionManager(mode);
        String sqlString = "SELECT * FROM " + User.getTablename() + " WHERE id = " + Integer.toString(id);
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sqlString);
            //manager.preparedStatement.setInt(1,id);
            manager.resultSet = manager.preparedStatement.executeQuery();
            if (manager.resultSet.next()){
                user.setID(manager.resultSet.getInt("id"));
                user.setFirstName(manager.resultSet.getString("firstname"));
                user.setLastName(manager.resultSet.getString("lastname"));
                user.setUsername();
                user.setEmail(manager.resultSet.getString("email"));
                user.setPassword(manager.resultSet.getString("password"));
                user.setStatus(manager.resultSet.getString("status"));
                if (manager.resultSet.getInt("isLoggedIn") == 0) {
                    user.setLogin(false);
                } else {
                    user.setLogin(true);
                }
                user.setID(manager.resultSet.getInt("id"));
            }
            //manager.preparedStatement.executeQuery());
        } catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    public static User GetByLoginCredentials(String email, String password, String mode){
        User user = new User();
        ConnectionManager manager = new ConnectionManager(mode);
        String sqlString = "SELECT * FROM " + User.getTablename() + " WHERE email = ? AND password = ?";
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sqlString);
            manager.preparedStatement.setString(1, email);
            manager.preparedStatement.setString(2, password);
            manager.resultSet = manager.preparedStatement.executeQuery();
            if(manager.resultSet.next()){
                //user = new User();
                user.setID(manager.resultSet.getInt("id"));
                user.setFirstName(manager.resultSet.getString("firstname"));
                user.setLastName(manager.resultSet.getString("lastname"));
                user.setEmail(manager.resultSet.getString("email"));
                user.setUsername();
                user.setPassword(manager.resultSet.getString("password"));
                user.setStatus(manager.resultSet.getString("status"));
                if (manager.resultSet.getInt("isLoggedIn") == 0){
                    user.setLogin(false);
                }else{
                    user.setLogin(true);
                }
            }else{
                return null;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    public static boolean Authenticate(String email, String password, String mode){
        //boolean authenticated = false;
        if (User.GetByLoginCredentials(email, password, mode) == null){
            return false;
        } else{
            return true;
        }
        
    }
    
    
}
