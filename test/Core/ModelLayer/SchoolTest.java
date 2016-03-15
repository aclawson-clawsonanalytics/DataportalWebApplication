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
        School.ClearTestDatabase();
        SUT = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void DefaultTablenameIsCorrect(){
        Assert.assertEquals(School.getTablename(),"SCHOOLS");
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
    
}
