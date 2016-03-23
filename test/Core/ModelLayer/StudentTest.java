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
    public static String sutFirstname = "sutFirst";
    public static String sutLastname = "sutLast";
    public static String sutGender = "Male";
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
    
    @Test
    public void DefaultIDIsZero(){
        Assert.assertEquals(SUT.getID(),0);
    }
    
    @Test
    public void CanSetFirstname(){
        SUT.setFirstname(sutFirstname);
        Assert.assertEquals(SUT.getFirstname(),sutFirstname);
        
    }
    
    @Test
    public void MissingFirstnameReturnsMessage(){
        try{
            Assert.assertTrue(SUT.GetValidationErrors().contains("Student must have a firstname."));
        }catch (NullPointerException e){
            Assert.assertNull(SUT.getFirstname());
        }
    }
    
    @Test
    public void MissingFirstnameReturnsInvalid(){
        try{
            Assert.assertFalse(SUT.IsValid());
        }catch(NullPointerException e){
            Assert.assertNull(SUT.getFirstname());
        }
    }
    
    
    @Test
    public void CanSetLastname(){
        SUT.setLastname(sutLastname);
        Assert.assertEquals(SUT.getLastname(), sutLastname);
    }
    
    @Test
    public void MissingLastnameReturnsMessage(){
        try{
            Assert.assertTrue(SUT.GetValidationErrors().contains("Student must have a lastname."));
        }catch(NullPointerException e){
            Assert.assertNull(SUT.getLastname());
        }
    }
    
    @Test
    public void MissingLastnameReturnsInvalid(){
        SUT.setFirstname(sutFirstname);
        try{
            Assert.assertFalse(SUT.IsValid());
        }catch(NullPointerException e){
            Assert.assertNull(SUT.getLastname());
        }
    }
    
    @Test
    public void CanSetGender(){
        SUT.setFirstname(sutFirstname);
        SUT.setLastname(sutLastname);
        SUT.setGender(sutGender);
        Assert.assertEquals(SUT.getGender(),sutGender);
        
    }
    
    @Test
    public void MissingGenderReturnsMessage(){
        SUT.setFirstname(sutFirstname);
        SUT.setLastname(sutLastname);
        SUT.setGender("");
        Assert.assertTrue(SUT.GetValidationErrors().contains("Student is missing a gender."));
    }
    
    @Test
    public void MissingGenderReturnsInvalid(){
        SUT.setFirstname(sutFirstname);
        SUT.setLastname(sutLastname);
        SUT.setGender("");
        Assert.assertFalse(SUT.IsValid());
        
    }
    
    @Test
    public void InvalidGenderReturnsMessage(){
        SUT.setGender("sfkjsdflk");
        Assert.assertTrue(SUT.GetValidationErrors().contains("Gender must be Male or Female."));
        
    }
    
    @Test
    public void InvalidGenderReturnsInvalid(){
        SUT.setFirstname(sutFirstname);
        SUT.setLastname(sutLastname);
        SUT.setGender("sldfkjslkgj");
        Assert.assertFalse(SUT.IsValid());
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
