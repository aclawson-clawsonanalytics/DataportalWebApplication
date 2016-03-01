/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import Core.Database.ConnectionManager;
import Core.Database.SQLModel;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author andrewclawson
 */
public class SQLModelTest {
    public static SQLModel SUT;
    public static String testTableName = "testTableName";
    
    public SQLModelTest() {
        
    }
    
    @BeforeClass
    public static void setUp() {
        
        SUT = new SQLModel();
    }
    
    @AfterClass
    public static void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void HasTableName(){
        SUT.TableName = testTableName;
        Assert.assertNotNull(SUT.TableName);
    }
    
    @Test
    public void EmptyErrorListReturnsValid(){
        SUT.TableName = testTableName;
        Assert.assertEquals(SUT.GetValidationErrors().isEmpty(), true);
    }
    
    @Test
    public void MissingTableNameReturnsMessage(){
        SUT.TableName = null;
        Assert.assertEquals(SUT.GetValidationErrors().contains("Null table name."),true);
    }
    
    @Test
    public void MissingTableNameReturnsInvalid(){
        SUT.TableName = null;
        Assert.assertEquals(SUT.IsValid(),false);
    }
    
    
    
}
