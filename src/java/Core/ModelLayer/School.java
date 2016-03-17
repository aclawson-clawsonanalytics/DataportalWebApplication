/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;

import java.util.List;
import java.util.ArrayList;
import Core.Database.ConnectionManager;
import Core.Database.ISQLInterface;
import Core.Database.SQLModel;

import java.sql.SQLException;

/**
 *
 * @author andrewclawson
 */
public class School extends SQLModel {
    private static String tablename;
    private String name;
    
    public School(){
        setTablename("SCHOOL");
        super.setID(0);
    }
    public static void setTablename(String string){
        tablename = string;
    }
    
    public static String getTablename(){
        return tablename;
    }
    public void setName(String string){
        this.name = string;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public ArrayList<String> GetValidationErrors(){
        ArrayList validationErrors = new ArrayList<String>();
        if(this.getName() == null || this.getName() == ""){
            validationErrors.add("School must have a name.");
        }
        return validationErrors;
    }
    
    @Override
    public void Save(String mode){
        if (this.getID() == 0){
            if (this.IsValid()){
                super.SetIDBySQL("TEST_MODE",School.getTablename());
                String sqlString = "INSERT INTO SCHOOL (name)"
                        + "VALUES (?)";
                try{
                    ConnectionManager manager = new ConnectionManager(mode);
                    manager.preparedStatement = manager.connection.prepareStatement(sqlString);
                    manager.preparedStatement.setString(1, this.getName());
                    manager.preparedStatement.execute();
                    manager.CloseResources();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    public void Update(String mode){
        if (this.getID() != 0){
            if (this.IsValid()){
                String sqlString = "UPDATE SCHOOL SET name = ? WHERE id = ?";
                try{
                    ConnectionManager manager = new ConnectionManager(mode);
                    manager.preparedStatement = manager.connection.prepareStatement(sqlString);
                    manager.preparedStatement.setString(1, this.getName());
                    manager.preparedStatement.setInt(2, this.getID());
                    manager.preparedStatement.executeUpdate();
                    manager.CloseResources();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static ArrayList<School> GetAll(String mode){
        ArrayList<School> allSchools = new ArrayList<School>();
        ConnectionManager manager = new ConnectionManager(mode);
        String sql = "SELECT * FROM " + School.getTablename();
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sql);
            manager.resultSet = manager.preparedStatement.executeQuery();
            while(manager.resultSet.next()){
                School aSchool = new School();
                aSchool.setID(manager.resultSet.getInt("id"));
                aSchool.setName(manager.resultSet.getString("name"));
                allSchools.add(aSchool);
            }
            manager.CloseResources();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allSchools;
    }
    
    public static School GetByID(int id, String mode){
        School school = new School();
        ConnectionManager manager = new ConnectionManager(mode);
        String sql = "SELECT * FROM " + School.getTablename() + " WHERE id = " + Integer.toString(id);
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sql);
            manager.resultSet = manager.preparedStatement.executeQuery();
            if (manager.resultSet.next()){
                school.setID(manager.resultSet.getInt("id"));
                school.setName(manager.resultSet.getString("name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return school;
    }
    
}
