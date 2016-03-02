/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

import Core.ModelLayer.User;

/**
 *
 * @author andrewclawson
 */
public class UserTest {
    public static String sutFirst = "testFirst";
    public static String sutLast = "testLast";
    public static String sutPassword = "testPassword";
    public static User SUT;
    
    public UserTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        SUT = new User();
        //SUT.setFirstName(sutFirst);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CanSetFirstName(){
        SUT.setFirstName(sutFirst);
        Assert.assertEquals(SUT.getFirstName(),sutFirst);
    }
    
    @Test
    public void CanSetLastName(){
        SUT.setLastName(sutLast);
        Assert.assertEquals(SUT.getLastName(),sutLast);
    }
    
    @Test
    public void UsernameIsNotNull(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        Assert.assertNotNull(SUT.getUsername());
    }
    
    @Test
    public void UsernameIsCorrect(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        Assert.assertEquals(SUT.getUsername(),"ttestlast");
    }
    
    @Test
    public void TableNameIsCorrect(){
        Assert.assertEquals(SUT.getTablename(),"USERS");
    }
}
