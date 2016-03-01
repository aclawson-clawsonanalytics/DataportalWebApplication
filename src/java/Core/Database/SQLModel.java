/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import java.util.ArrayList;
import Core.Database.ISQLInterface;
import Core.ModelLayer.*;


/**
 *
 * @author andrewclawson
 */
public class SQLModel implements IValidatable, ISQLInterface {
    
    public String TableName;
    public int ID;
    
    public SQLModel (){
 
    }
    
    @Override
    public void SetID(){
        
    }
    
    @Override
    public int GetID(){
        return ID;
    }
    
    @Override
    public ArrayList GetAll(){
        return null;
    }
    
    @Override
    public void Save(){
        
    }
    
    @Override
    public void Delete(){
        
    }
    
    @Override
    public ArrayList<String> GetValidationErrors(){
        ArrayList<String> _validationErrors = new ArrayList<String>();
        if (TableName == null){
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
