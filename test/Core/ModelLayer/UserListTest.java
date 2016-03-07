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

import Core.ModelLayer.UserList;
//import junit.framework.Assert;
/**
 *
 * @author andrewclawson
 */
public class UserListTest {
    private UserList SUT = new UserList();
    public UserListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        UserList SUT = new UserList();
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
    public void TablenameIsCorrect(){
        Assert.assertEquals(SUT.getTablename(), "USER");
    }
}
