/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import java.sql.Array;
import Core.Database.ConnectionManager;
import Core.Database.SQLList;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author andrewclawson
 */
public interface ISQLInterface {
    
    // SetID method
    // Sets the primary key for the SQLListItem
    public void SetID();
    
    // Returns the Item's Primary Key
    int GetID();
    
    /* Returns all objects of the parent class from
    the SQL Database
    */
    void Save();
    
    void Delete();
    
    
    abstract ArrayList GetAll();
    
    
    
    
}
