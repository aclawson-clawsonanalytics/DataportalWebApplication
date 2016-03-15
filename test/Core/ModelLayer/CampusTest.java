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
public class CampusTest {
    public static String sutName = "testName";
    public static Campus SUT;
    public static String mode = "TEST_MODE";
    
    public CampusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Before
    public void setup(){
        Campus SUT = new Campus();
    }
    
    @After
    public void teardownDatabase(){
        Campus.ClearTestDatabase();
        SUT = null;
    }
    
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals(Campus.getTablename(),"CAMPUSES");
    }
}
