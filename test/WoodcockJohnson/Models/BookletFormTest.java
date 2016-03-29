/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoodcockJohnson.Models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

import java.sql.Date;

import Core.Database.ConnectionManager;
import Core.Database.Settings;

import Core.ModelLayer.School;
import Core.ModelLayer.Campus;
import Core.ModelLayer.Student;

import WoodcockJohnson.Reference.FormReference;
import WoodcockJohnson.Models.BookletForm;
/**
 *
 * @author andrewclawson
 */
public class BookletFormTest {
    public static String sutLabel;
    public static BookletForm SUT;
    public static String formLabel = "A";
    public static String mode = "TEST_MODE";
    public static School TestSchool;
    public static Campus TestCampus;
    public static Student TestStudent;
    public static Date sutDate;
    
    public BookletFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        TestSchool = new School();
        TestSchool.setName("testSchool");
        TestSchool.Save(mode);
        TestCampus = new Campus();
        TestCampus.setName("testCampus");
        TestCampus.setSchool(TestCampus.getID());
        TestCampus.Save(mode);
        TestStudent = new Student();
        TestStudent.setFirstname("testFirst");
        TestStudent.setLastname("testLast");
        TestStudent.setCampus(TestCampus.GetID());
        TestStudent.setGender("Male");
        TestStudent.setGradeLevel(9);
        TestStudent.Save(mode);
        //SUT = new BookletForm();
    }
    
    @AfterClass
    public static void tearDownClass() {
        BookletForm.DeleteTestDatabase(BookletForm.getTablename());
        Student.DeleteTestDatabase(Student.getTablename());
        Campus.DeleteTestDatabase(Campus.getTablename());
        School.DeleteTestDatabase(School.getTablename());
        
    }
    
    @Before
    public void setUp() {
        SUT = new BookletForm();
    }
    
    @After
    public void tearDown() {
        BookletForm.DeleteTestDatabase(BookletForm.getTablename());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TablenameIsNotNull(){
        Assert.assertNotNull(BookletForm.getTablename());
    }
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals(BookletForm.getTablename(),"Form");
    }
    
    @Test
    public void ReferenceTablenameIsNotNull(){
        Assert.assertNotNull(BookletForm.getReferenceTablename());
        
    }
    
    @Test
    public void ReferenceTablenameIsCorrect(){
        Assert.assertEquals(BookletForm.getReferenceTablename(),"FormReference");
    }
    
    @Test
    public void CanSetStudentID(){
        SUT.setStudentID(TestStudent.getID());
        Assert.assertEquals(SUT.getStudentID(),TestStudent.getID());
    }
    
    @Test
    public void StudentExistsInDatabase(){
        SUT.setStudentID(TestStudent.getID());
        Student retrievedStudent = Student.GetByID(SUT.getStudentID(), mode);
        Assert.assertNotNull(retrievedStudent);
    }
    
    @Test
    public void CanSetAssessmentDate(){
        sutDate = new Date(System.currentTimeMillis());
        SUT.setAssessmentDate(sutDate);
        Assert.assertEquals(SUT.getAssessmentDate(),sutDate);
        
    }
    
    @Test
    public void CanSetReferenceID(){
        int testID = 1;
        SUT.setReferenceID(testID);
        Assert.assertEquals(SUT.getReferenceID(),testID);
    }
    @Test
    public void AReferenceIDExists(){
        int testID = 1;
        SUT.setReferenceID(testID);
        //FormReference reference = FormReference.GetReferenceByID(testID, "PRODUCTION");
        Assert.assertNotNull(FormReference.GetReferenceByID(SUT.getReferenceID(),"PRODUCTION"));
        
        
    }
    
    @Test
    public void BReferenceIDExists(){
        int testID = 2;
        SUT.setReferenceID(testID);
        Assert.assertNotNull(FormReference.GetReferenceByID(SUT.getReferenceID(), "PRODUCTION"));
    }
    
    @Test
    public void NonExistentReferenceIDContainsMessage(){
        int falseReferenceID = 0;
        SUT.setReferenceID(falseReferenceID);
        Assert.assertTrue(SUT.GetValidationErrors().contains("Invalid reference ID."));
        
    }
    
    @Test
    public void ReferenceStudentExists(){
        SUT.setStudentID(TestStudent.getID());
        Student studentCheck = Student.GetByID(SUT.getStudentID(), mode);
        Assert.assertNotNull(studentCheck);
    }
    
    
}
