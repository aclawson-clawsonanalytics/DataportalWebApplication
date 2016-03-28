/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoodcockJohnson.Reference;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

import WoodcockJohnson.Reference.FormReference;
/**
 *
 * @author andrewclawson
 */
public class FormReferenceTest {
    public static int id = 1;
    public static FormReference SUT;
    public static String mode = "PRODUCTION";
    
    public FormReferenceTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        //SUT = new FormReference();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CanGetFormAReferenceByID(){
        int referenceID = 1;
        SUT = FormReference.GetReferenceByID(referenceID, mode);
        Assert.assertEquals(SUT.getLabel(),"A");
    }
    
    @Test
    public void CanGetFormBReferenceByID(){
        int referenceID = 2;
        SUT = FormReference.GetReferenceByID(referenceID,mode);
        Assert.assertEquals(SUT.getLabel(), "B");
    }
}
