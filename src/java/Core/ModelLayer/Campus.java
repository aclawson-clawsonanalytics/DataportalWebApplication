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
import Core.ModelLayer.School;
import java.sql.SQLException;
/**
 *
 * @author andrewclawson
 */
public class Campus extends SQLModel {
    private String name;
    private int schoolID;
    
    public Campus(){
        super.setTablename("CAMPUS");
        super.setID(0);
    }
    
    public void setName(String string){
        this.name = string;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setSchool(int school_id){
        this.schoolID = school_id;
    }
    
    public int getSchoolID(){
        return this.schoolID;
    }
    
    @Override
    public ArrayList<String> GetValidationErrors(){
        ArrayList<String> validationErrors = new ArrayList<String>();
        if(this.getName() == null || this.getName() == ""){
            validationErrors.add("Campus must have a name.");
        }
        
        return validationErrors;
    }
    
    
    
}
