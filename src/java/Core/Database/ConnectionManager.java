/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
//import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import Core.Database.Settings;
/**
 *
 * @author andrewclawson
 */
public class ConnectionManager {
    public Settings settings = new Settings();
    public String host;
    public String userName = settings.username;
    public String password = settings.password;
    public Connection connection;
    public Statement statement = null;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    public String errorMessage = null;
    
    public ConnectionManager(String mode){
        if (mode.equals("TEST_MODE")){
            host = settings.testHost;
        }
        
        if (mode.equals("PRODUCTION")){
            host = settings.host;
        }
        connection = this.GetConnection();
    }
    
    public Connection GetConnection (){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(host, userName, password);
        } catch (SQLException err){
            errorMessage = err.getMessage()+"\n";
            errorMessage = errorMessage + "Connection set to null value.";
            System.out.println(errorMessage);
            connection = null;
        }
        
        return connection;
    }
    
    public void CloseResources (){
        try {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e){
            errorMessage = "Error Code: " + e.getErrorCode() + "\n"
                    + e.getMessage();
            System.out.println(errorMessage);
        }
    }

}
