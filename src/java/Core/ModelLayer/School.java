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
    
}
