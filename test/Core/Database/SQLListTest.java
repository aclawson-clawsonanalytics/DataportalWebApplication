/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import Core.Database.SQLList;
//import junit.framework.Assert;

/**
 *
 * @author andrewclawson
 */
public class SQLListTest {
    private static String tableName = "sutTablename";
    private static SQLList SUT;
    public SQLListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        SUT = new SQLList();
        SUT.setTablename(tableName);
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
    public void DefaultTableNameIsCorrect(){
        Assert.assertEquals(SUT.getTablename(), tableName);       
    }
}
