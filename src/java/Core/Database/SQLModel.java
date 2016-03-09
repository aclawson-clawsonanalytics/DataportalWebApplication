/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import Core.Database.ISQLInterface;
import Core.Database.ConnectionManager;
import Core.ModelLayer.*;



/**
 *
 * @author andrewclawson
 */
public class SQLModel implements IValidatable, ISQLInterface {
    
    private static String tablename;
    private int ID;
    
    public SQLModel (){
 
    }
    
    public void setTablename(String string){
        this.tablename = string;
    }
    
    public static String getTablename(){
        return tablename;
    }
    
    public void setID(int id){
        ID = id;
    }
    
    public int getID(){
        return this.ID;
    }
    
    
    @Override
    public void SetIDBySQL(String mode){
        ConnectionManager manager = new ConnectionManager(mode);
        ArrayList idList = new ArrayList();
        String sqlString = "SELECT id from " + tablename;
        try{
            manager.statement = manager.connection.createStatement();
            manager.resultSet = manager.statement.executeQuery(sqlString);
            while (manager.resultSet.next()){
                int id = manager.resultSet.getInt("id");
                idList.add(id);
            }
            try{
                int maxID = (Integer) Collections.max(idList);
                ID = maxID + 1;
            } catch (Exception e){
                ID = 1;
            }
            
            manager.CloseResources();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public int GetID(){
        return ID;
    }
    
    
    @Override
    public void Save(){
        
    }
    
    @Override
    public void Save(String mode){
        
    }
    @Override
    public void Delete(){
        
    }
    
    
    public static int Count(){
        int count = 0;
        String sqlString = "SELECT * from " + getTablename();
        try{
            ConnectionManager manager = new ConnectionManager("PRODUCTION");
            manager.statement = manager.connection.createStatement();
            manager.resultSet = manager.statement.executeQuery(sqlString);
            while (manager.resultSet.next()){
                count = count + 1;
            }
            manager.CloseResources();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }
    
    public static int Count(String mode){
        int count = 0;
        String sqlString = "SELECT * from " + getTablename();
        
        try{
            ConnectionManager manager = new ConnectionManager(mode);
            manager.statement = manager.connection.createStatement();
            manager.resultSet = manager.statement.executeQuery(sqlString);
            while (manager.resultSet.next()){
                count = count + 1;
            }
            manager.CloseResources();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
    
    public static void ClearTestDatabase(){
        ConnectionManager manager = new ConnectionManager("TEST_MODE");
        String deleteString = "TRUNCATE TABLE " + getTablename();
        try{
            manager.preparedStatement = manager.connection.prepareStatement(deleteString);
            manager.preparedStatement.execute();
            manager.CloseResources();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
    @Override
    public ArrayList<String> GetValidationErrors(){
        ArrayList<String> _validationErrors = new ArrayList<String>();
        if (tablename == null){
            _validationErrors.add("Null table name.");
        }
        return _validationErrors;
    }
    
    @Override
    public boolean IsValid(){
        if (this.GetValidationErrors().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
