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
import Core.ModelLayer.Campus;

/**
 *
 * @author andrewclawson
 */
public class CampusTest {
    public static String sutName = "testName";
    public static Campus SUT;
    public static String mode = "TEST_MODE";
    public static School TestSchool;
    public static String testSchoolName = "testSchoolName";
    
    public CampusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Campus SUT = new Campus();
        TestSchool = new School();
        TestSchool.setName(testSchoolName);
        TestSchool.Save(mode);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        School.DeleteTestDatabase(School.getTablename());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Before
    public void setup(){
        SUT = new Campus();
        //SUT.setName(sutName);
        //SUT.setSchool(TestSchool.getID());
    }
    
    @After
    public void teardownDatabase(){
        Campus.DeleteTestDatabase(Campus.getTablename());
        //School.DeleteTestDatabase(School.getTablename());
        SUT = null;
    }
    
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals(Campus.getTablename(),"CAMPUS");
    }
    
    @Test
    public void DefaultIDIsZero(){
        Assert.assertEquals(SUT.getID(), 0);
    }
    
    @Test
    public void CanSetName(){
        SUT.setName(sutName);
        Assert.assertEquals(SUT.getName(), sutName);
    }
    
    @Test
    public void MisingNameReturnsMessage(){
        Assert.assertTrue(SUT.GetValidationErrors().contains("Campus must have a name."));
    }
    
    @Test
    public void MissingNameReturnsInvalid(){
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void CountEmptyDatabaseReturnsZero(){
        int numberCampuses = Campus.Count("TEST_MODE",Campus.getTablename());
        Assert.assertEquals(0, numberCampuses);
    }
    
    @Test
    public void CanSaveNewCampus(){
        SUT.setName(sutName);
        SUT.setSchool(TestSchool.getID());
        int firstCount = 0;
        int secondCount = 0;
        try{
            ConnectionManager manager = new ConnectionManager(mode);
            manager.statement = manager.connection.createStatement();
            String sqlString = "SELECT * FROM " + Campus.getTablename();
            manager.resultSet = manager.statement.executeQuery(sqlString);
            while(manager.resultSet.next()){
                firstCount = firstCount + 1;
            }
            SUT.Save(mode);
            manager.resultSet = manager.statement.executeQuery(sqlString);
            while(manager.resultSet.next()){
                secondCount = secondCount + 1;
            }
            Assert.assertEquals(secondCount, firstCount+1);
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void SaveIncreasesCountByOne(){
        int campusCount = Campus.Count(mode,Campus.getTablename());
        SUT.setName(sutName);
        SUT.setSchool(TestSchool.getID());
        SUT.Save(mode);
        Assert.assertEquals(Campus.Count(mode,Campus.getTablename()),campusCount+1);
        
    }
    
    @Test
    public void UpdateKeepsCountStatic(){
        SUT.setName(sutName);
        SUT.setSchool(TestSchool.getID());
        SUT.Save(mode);
        int campusCount = Campus.Count(mode,Campus.getTablename());
        SUT.Update(mode);
        Assert.assertEquals(Campus.Count(mode,Campus.getTablename()), campusCount);
        
        
    }
    
    
    @Test
    public void CanRetreiveAllCampusesForSchool(){
        SUT.setName(sutName);
        SUT.setSchool(TestSchool.getID());
        SUT.Save("TEST_MODE");
        ArrayList<Campus> all = Campus.GetAll("TEST_MODE");
        //Assert.assertEquals(all.size(), User.Count("TEST_MODE"));
        Assert.assertFalse(all.isEmpty());
    }
    
    
    @Test
    public void CanUpdateExistingCampusName(){
        SUT.setName(sutName);
        SUT.setSchool(TestSchool.getID());
        SUT.Save(mode);
        int id = SUT.getID();
        String newSUTName = "newSUTName";
        SUT.setName(newSUTName);
        SUT.Update(mode);
        SUT = null;
        Campus newCampus = Campus.GetByID(id, mode);
        Assert.assertEquals(newCampus.getName(),newSUTName);
    }
    
    
    
}
