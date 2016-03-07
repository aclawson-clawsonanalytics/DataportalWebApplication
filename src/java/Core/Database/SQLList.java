/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import java.util.*;
import java.util.ArrayList;
import Core.Database.SQLList;
import java.sql.Array;
import Core.Database.ISQLInterface;
import Core.Database.ConnectionManager;
/**
 *
 * @author andrewclawson
 */
public class SQLList extends ArrayList {
    private String tablename;
    public ArrayList Items;
    
    // Constructor method
    public SQLList(){
        
        
    }
    
    public void setTablename(String string){
        this.tablename = string;
    }
    
    public String getTablename(){
        return tablename;
    }
    
    public void Add(SQLModel aListItem){
        
    }
    
    public void Delete(SQLModel aListItem){
        
    }
    /*
    public ArrayList All(String mode){
        ConnectionManager manager = new ConnectionManager(mode);
        String sqlString = "SELECT * From " + this.getTablename();
    }
*/
}
