/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;
import Core.Database.SQLList;
/**
 *
 * @author andrewclawson
 */
public class UserList extends SQLList{
    private String tablename;
    
    public UserList(){
        this.setTablename("USER");
    }
    
    public void setTablename(String string){
        this.tablename = string;
    }
    
    public String getTablename(){
        return tablename;
    }
    
    
}
