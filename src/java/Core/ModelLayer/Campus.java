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
    private static String tablename;
    private String name;
    private int schoolID;
    
    public Campus(){
        setTablename("CAMPUS");
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
    
    @Override
    public void Save(String mode){
        if (this.getID() == 0){
            if (this.IsValid()){
                super.SetIDBySQL(mode, Campus.getTablename());
                String sqlString = "INSERT INTO CAMPUS (name,school_id)"
                        + " VALUES(?,?)";
                try{
                    ConnectionManager manager = new ConnectionManager(mode);
                    manager.preparedStatement = manager.connection.prepareStatement(sqlString);
                    manager.preparedStatement.setString(1, this.getName());
                    manager.preparedStatement.setInt(2, this.getSchoolID());
                    manager.preparedStatement.execute();
                    manager.CloseResources();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static Campus GetByID(int id, String mode){
        Campus campus = new Campus();
        ConnectionManager manager = new ConnectionManager(mode);
        String sql = "SELECT * FROM " + Campus.getTablename() + " WHERE id = " + Integer.toString(id);
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sql);
            manager.resultSet = manager.preparedStatement.executeQuery();
            if (manager.resultSet.next()){
                campus.setID(manager.resultSet.getInt("id"));
                campus.setName(manager.resultSet.getString("name"));
                campus.setSchool(manager.resultSet.getInt("school_id"));
            }
            manager.CloseResources();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return campus;
    }
    
    public void Update(String mode){
        if (this.getID() != 0){
            if (this.IsValid()){
                String sql = "UPDATE CAMPUS set name = ?, school_id = ?  WHERE id = ?";
                ConnectionManager manager = new ConnectionManager(mode);
                try{
                    manager.preparedStatement = manager.connection.prepareStatement(sql);
                    manager.preparedStatement.setString(1, this.getName());
                    manager.preparedStatement.setInt(2,this.getSchoolID());
                    manager.preparedStatement.setInt(3, this.getID());
                    manager.preparedStatement.executeUpdate();
                    manager.CloseResources();
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    public static ArrayList<Campus> GetAll(String mode){
        ArrayList allCampuses = new ArrayList<Campus>();
        ConnectionManager manager = new ConnectionManager(mode);
        String sql = "SELECT * FROM " + Campus.getTablename();
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sql);
            manager.resultSet = manager.preparedStatement.executeQuery();
            while (manager.resultSet.next()){
                Campus newCampus = new Campus();
                newCampus.setID(manager.resultSet.getInt("id"));
                newCampus.setName(manager.resultSet.getString("name"));
                newCampus.setSchool(manager.resultSet.getInt("school_id"));
                allCampuses.add(newCampus);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return allCampuses;
    }
    
    public ArrayList<Student> StudentSet(String mode){
        ArrayList<Student> studentSet = new ArrayList<Student>();
        ConnectionManager manager = new ConnectionManager(mode);
        String sql = "SELECT * FROM " + Student.getTablename() + " WHERE id = " + this.getID();
        try{
            manager.preparedStatement = manager.connection.prepareStatement(sql);
            manager.resultSet = manager.preparedStatement.executeQuery();
            while(manager.resultSet.next()){
                Student student = new Student();
                student.setFirstname(manager.resultSet.getString("firstname"));
                student.setLastname(manager.resultSet.getString("lastname"));
                student.setGender(manager.resultSet.getString("gender"));
                student.setGradeLevel(manager.resultSet.getInt("gradelevel"));
                student.setCampus(manager.resultSet.getInt("campus_id"));
                student.setID(manager.resultSet.getInt("id"));
                studentSet.add(student);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return studentSet;
    }
    
    
}
