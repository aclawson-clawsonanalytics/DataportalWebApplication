/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import Core.Database.ConnectionManager;
import Core.Database.SQLModel;
import Core.ModelLayer.IValidatable;
import Core.ModelLayer.School;


/**
 *
 * @author andrewclawson
 */
public class SchoolTest {
    public static String sutName = "testName";
    public static School SUT;
    public static String mode = "TEST_MODE";
    public SchoolTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setup(){
        SUT = new School();
    }
    
    @After
    public void tearDownDatabase(){
        School.DeleteAllFromTestDatabase(School.getTablename());
        SUT = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void DefaultTablenameIsCorrect(){
        Assert.assertEquals(School.getTablename(),"SCHOOL");
    }
    @Test
    public void DefaultIDIsZero(){
        Assert.assertEquals(SUT.getID(),0);
    }
    
    @Test
    public void CanSetName(){
        SUT.setName(sutName);
        Assert.assertEquals(SUT.getName(), sutName);
    }
    
    @Test
    public void MissingNameReturnsMessage(){
        Assert.assertTrue(SUT.GetValidationErrors().contains("School must have a name."));
    }
    
    @Test
    public void MissingNameReturnsInvalid(){
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void CountEmptyDatabaseReturnsZero(){
        int numberSchools = School.Count(mode,School.getTablename());
        Assert.assertEquals(0, numberSchools);
    }
    
    @Test
    public void CanSaveNewSchool(){
        SUT.setName(sutName);
        int firstCount = 0;
        int secondCount = 0;
        
        try{
            ConnectionManager manager = new ConnectionManager("TEST_MODE");
            manager.statement = manager.connection.createStatement();
            String sqlString = "SELECT * FROM " + SUT.getTablename();
            manager.resultSet = manager.statement.executeQuery(sqlString);
            while (manager.resultSet.next()){
                firstCount = firstCount + 1;
            }
            SUT.Save("TEST_MODE");
            manager.resultSet = manager.statement.executeQuery(sqlString);
            while (manager.resultSet.next()){
                secondCount = secondCount + 1;
            }
            Assert.assertEquals(secondCount,firstCount + 1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    @Test
    public void SaveIncreasesCountByOne(){
        int numberSchools = School.Count(mode,School.getTablename());
        SUT.setName(sutName);
        SUT.Save(mode);
        Assert.assertEquals(School.Count(mode,School.getTablename()), numberSchools+1);
        
    }
    
    @Test
    public void UpdateKeepsCountStatic(){
        SUT.setName(sutName);
        int numberSchools = School.Count(mode,School.getTablename());
        SUT.Update(mode);
        Assert.assertEquals(School.Count(mode,School.getTablename()), numberSchools);
    }
    
    @Test
    public void CanRetreiveAllSchools(){
        
        SUT.setName(sutName);
        
        SUT.Save("TEST_MODE");
        ArrayList<School> all = School.GetAll("TEST_MODE");
        //Assert.assertEquals(all.size(), User.Count("TEST_MODE"));
        Assert.assertFalse(all.isEmpty());
    }
    
    @Test
    public void CanUpdateExistingSchoolName(){
        SUT.setName(sutName);
        SUT.Save(mode);
        int id = SUT.getID();
        String newName = "newSUTName";
        SUT.setName(newName);
        SUT.Update(mode);
        SUT = null;
        School newSUT = School.GetByID(id, mode);
        Assert.assertEquals(newSUT.getName(), newName);
    }
}
