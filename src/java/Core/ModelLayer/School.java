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
    private String name;
    
    public School(){
        super.setTablename("SCHOOLS");
        super.setID(0);
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
                String sqlString = "INSERT INTO SCHOOLS (name)"
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
        
    }
    
    public static ArrayList<School> GetAll(String mode){
        ArrayList<School> allSchools = new ArrayList<School>();
        
        return allSchools;
    }
    
}
