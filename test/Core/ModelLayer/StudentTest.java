/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

import Core.ModelLayer.School;
import Core.ModelLayer.Campus;

/**
 *
 * @author andrewclawson
 */
public class StudentTest {
    
    public static String mode = "TEST_MODE";
    public static School TestSchool;
    public static String testSchoolName = "testSchoolName";
    public static String testCampusName = "testCampusName";
    public static Campus TestCampus;
    public static Student SUT;
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        TestSchool = new School();
        TestSchool.setName(testSchoolName);
        TestSchool.Save(mode);
        TestCampus = new Campus();
        TestCampus.setName(testCampusName);
        TestCampus.setSchool(TestSchool.getID());
        TestCampus.Save(mode);
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        Student.DeleteTestDatabase(Student.getTablename());
        Campus.DeleteTestDatabase(Campus.getTablename());
        School.DeleteTestDatabase(School.getTablename());
    }
    
    @Before
    public void setUp() {
        SUT = new Student();
    }
    
    @After
    public void tearDown() {
        Student.DeleteTestDatabase(Student.getTablename());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals(Student.getTablename(),"STUDENT");
    }
    
    //@Test
    public void DefaultIDIsZero(){
        
    }
    
    //@Test
    public void CanSetFirstname(){
        
    }
    
    //@Test
    public void MissingFirstnameReturnsMessage(){
        
    }
    
    //@Test
    public void MissingFirstnameReturnsInvalid(){
        
    }
    
    
    //@Test
    
    
    //@
    public void CanSetLastname(){
        
    }
    
    //@Test
    public void MissingLastnameReturnsMessage(){
        
    }
    
    //@Test
    public void MissingLastnameReturnsInvalid(){
        
    }
    
    //@Test
    public void CanSetGender(){
        
    }
    
    //@Test
    public void MissingGenderReturnsMessage(){
        
    }
    
    //@Test
    public void MissingGenderReturnsInvalid(){
        
    }
    
    //@Test
    public void InvalidGenderReturnsMessage(){
        
    }
    
    //@Test
    public void InvalidGenderReturnsInvalid(){
        
    }
    
    //@Test
    public void ValidGenderReturnsValid(){
        
    }
    
    //@Test
    public void CanSetGradeLevel(){
        
    }
    
    //@Test
    public void InvalidGradeLevelReturnsMessage(){
        
    }
    
    //@Test
    public void InvalidGradeLevelReturnsInvalid(){
        
    }
   
    //@Test
    public void ValidGradeLevelReturnsValid(){
        
    }
    
    //@Test
    public void CanSetCampus(){
        
    }
    
    //@Test
    public void UnsetCampusReturnsMessage(){
        
    }
    
    //@Test
    public void UnsetCampusReturnsInvalid(){
        
    }
    
    //@Test
    public void CampusIDMatchesExistingCampus(){
        
    }
    
    //@Test
    public void InvalidCampusIDReturnsMessage(){
        
    }
    
    //@Test
    public void InvalidCampusIDReturnsInvalid(){
        
    }
    
    
}
