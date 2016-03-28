/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoodcockJohnson.Reference;
import Core.Database.ConnectionManager;
import java.sql.SQLException;
/**
 *
 * @author andrewclawson
 */
public class FormReference {
    private int ID;
    private String label;
    
    public FormReference(){
        
    }
    
    public void setID(int id){
        this.ID = id;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public void setLabel(String string){
        this.label = string;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public static FormReference GetReferenceByID(int id, String mode){
        FormReference formReference = new FormReference();
        ConnectionManager manager = new ConnectionManager(mode);
        String sql = "SELECT * FROM FormReference WHERE id = " + Integer.toString(id);
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sql);
            manager.resultSet = manager.preparedStatement.executeQuery();
            if (manager.resultSet.next()){
                //FormReference formReference = new FormReference();
                formReference.setID(manager.resultSet.getInt("id"));
                formReference.setLabel(manager.resultSet.getString("label"));
                return formReference;
                
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

