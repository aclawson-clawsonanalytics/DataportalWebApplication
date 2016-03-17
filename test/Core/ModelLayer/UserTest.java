/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import java.util.ArrayList;
import Core.ModelLayer.User;
import java.util.Collections;
import Core.Database.ConnectionManager;
import java.sql.SQLException;
/**
 *
 * @author andrewclawson
 */
public class UserTest {
    public static String sutFirst = "testFirst";
    public static String sutLast = "testLast";
    public static String sutEmail = "testEmail@gmail.com";
    public static String sutPassword = "testPassword";
    //public static String testTable = "USERS_TEST";
    
    public static User SUT;
    
    public UserTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        //SUT = new User();
        //SUT.setTablename(testTable);
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
    @Before
    public void setup(){
        SUT = new User();
    }
    @After
    public void tearDownDatabase(){
        User.ClearTestDatabase(User.getTablename());
        SUT = null;
        
    }
    @Test
    public void DefaultIDIsZero(){
        Assert.assertEquals(SUT.getID(),0);
    }
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
    public void CanSetPassword(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setPassword(sutPassword);
        Assert.assertEquals(SUT.getPassword(), sutPassword);
    }
    @Test
    public void TableNameIsCorrect(){
        Assert.assertEquals(SUT.getTablename(),"USERS");
    }
    
    @Test
    public void MissingFirstReturnsMessage(){
        //SUT.setFirstName(sutFirst);
        SUT.setFirstName("");
        SUT.setLastName(sutLast);
        //SUT.setUsername();
        SUT.setPassword(sutPassword);
        SUT.setEmail(sutEmail);
        Assert.assertTrue(SUT.GetValidationErrors().contains("User must have first name."));
    }
    
    @Test
    public void MissingFirstReturnsInvalid(){
        SUT.setFirstName("");
        SUT.setLastName(sutLast);
        SUT.setPassword(sutPassword);
        SUT.setEmail(sutEmail);
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void MissingLastReturnsMessage(){
        SUT.setLastName("");
        SUT.setFirstName(sutFirst);
        SUT.setPassword(sutPassword);
        SUT.setEmail(sutEmail);
        Assert.assertTrue(SUT.GetValidationErrors().contains("User nust have last name."));
    }
    
    @Test
    public void MissingLastReturnsInvalid(){
        //SUT.setLastName("");
        SUT.setFirstName(sutFirst);
        SUT.setLastName("");
        SUT.setPassword(sutPassword);
        SUT.setEmail(sutEmail);
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void DefaultStatusIsActive(){
        Assert.assertEquals(SUT.getStatus(),"Active");
    }
    
    @Test
    public void DefaultLoginIsFalse(){
        Assert.assertFalse(SUT.getLoginStatus());
    }
    @Test
    public void EmptyEmailReturnsMessage(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail("");
        Assert.assertTrue(SUT.GetValidationErrors().contains("User must have email."));
    }
    
    @Test
    public void CanGetUserByID(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        User retreivedSUT = new User();
        retreivedSUT = User.GetByID(SUT.getID(), "TEST_MODE");
        Assert.assertEquals(SUT.getID(),retreivedSUT.getID());
    }
    
    @Test
    public void CanSaveNewUser(){
        SUT = new User();
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        //SUT.setTablename(test);
        int firstCount =0;
        int secondCount = 0;
        
        try{
            ConnectionManager manager = new ConnectionManager("TEST_MODE");
            manager.statement = manager.connection.createStatement();
            String sqlString = "SELECT * FROM " + SUT.getTablename();
            manager.resultSet = manager.statement.executeQuery(sqlString);
            while (manager.resultSet.next()){
                firstCount = firstCount + 1;
            }
            
            SUT.Save("TEST_MODE");
            manager.resultSet = manager.statement.executeQuery(sqlString);
            while (manager.resultSet.next()){
                secondCount = secondCount + 1;
            }
            Assert.assertEquals(secondCount,firstCount+1);
            
        }catch (SQLException e){
            e.printStackTrace();
            // Add more exception handling actions here.
        }
        
        
    }
    
    @Test
    public void CountEmptyDatabaseReturnsZero(){
        int numberUsers = User.Count("TEST_MODE",User.getTablename());
        Assert.assertEquals(0,numberUsers);
        
    }
    
    //@Test
    public void SaveIncreasesCountByOne(){
        int numberUsers = User.Count("TEST_MODE", User.getTablename());
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        Assert.assertEquals(User.Count("TEST_MODE",User.getTablename()),numberUsers+1);
    }
    
    @Test //- Working on this test on the cases where ID != 0.
    public void SaveExistingUserKeepsCountStatic(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setPassword(sutPassword);
        int numberUsers = User.Count("TEST_MODE", User.getTablename());
        SUT.Update("TEST_MODE");
        Assert.assertEquals(User.Count("TEST_MODE",User.getTablename()),numberUsers);
    }
    
    //@Test
    /*
    public void CanAuthenticateSavedUser(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        Assert.assertTrue(User.AuthenticateCredentials(sutEmail,sutPassword));
    }
*/  @Test
    public void CanRetreiveAllUsers(){
        
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        
        SUT.Save("TEST_MODE");
        ArrayList<User> all = User.GetAll("TEST_MODE");
        //Assert.assertEquals(all.size(), User.Count("TEST_MODE"));
        Assert.assertFalse(all.isEmpty());
    }
    
    
    @Test
    public void CanUpdateExistingUserFirstname(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setEmail(sutEmail);
        SUT.setUsername();
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        int sutID = SUT.getID();
        String newFirst = "newSUTFirst";
        SUT.setFirstName(newFirst);
        SUT.Update("TEST_MODE");
        SUT = null;
        User newSUT = User.GetByID(sutID,"TEST_MODE");
        Assert.assertEquals(newSUT.getFirstName(),newFirst);
        
    }
    
    @Test
    public void CanUpdateExistingUserLastname(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        int sutID = SUT.getID();
        String newLast = "newSUTLast";
        SUT.setLastName(newLast);
        SUT.Update("TEST_MODE");
        SUT = null;
        User newSUT = User.GetByID(sutID, "TEST_MODE");
        Assert.assertEquals(newSUT.getLastName(), newLast);
    }
    
    @Test
    public void CanUpdateExistingUserEmail(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        int sutID = SUT.getID();
        String newEmail = "newSUTEmail";
        SUT.setEmail(newEmail);
        SUT.Update("TEST_MODE");
        SUT = null;
        User newSUT = User.GetByID(sutID, "TEST_MODE");
        Assert.assertEquals(newSUT.getEmail(),newEmail);
    }
    
    @Test
    public void CanUpdateExistingUserPassword(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        int sutID = SUT.getID();
        String newPassword = "newSUTPassword";
        SUT.setPassword(newPassword);
        SUT.Update("TEST_MODE");
        SUT = null;
        User newSUT = User.GetByID(sutID,"TEST_MODE");
        Assert.assertEquals(newSUT.getPassword(),newPassword);
    }
    
    @Test
    public void CanUpdateExistingUserStatus(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        int sutID = SUT.getID();
        String newStatus = "Inactive";
        SUT.setStatus(newStatus);
        SUT.Update("TEST_MODE");
        SUT = null;
        User newSUT = User.GetByID(sutID,"TEST_MODE");
        Assert.assertEquals(newSUT.getStatus(),newStatus);
        
    }
    
    @Test
    public void CanGetUserByCredentials(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        int sutID = SUT.getID();
        SUT = null;
        User newSUT = User.GetByLoginCredentials(sutEmail, sutPassword, "TEST_MODE");
        Assert.assertEquals(newSUT.getID(),sutID);
    }
    
    @Test
    public void BadCredentialsReturnsNull(){
        User newSUT = User.GetByLoginCredentials("badEmail", "badPassword", "TEST_MODE");
        Assert.assertNull(newSUT);
    }
    
    @Test
    public void CannotAuthenticateBadCredentials(){
        String badEmail = "badEmail";
        String badPassword = "badPassword";
        Assert.assertFalse(User.Authenticate(badEmail, badPassword, "TEST_MODE"));
    }
    
    @Test
    public void CanAuthenticateGoodCredentials(){
        SUT.setFirstName(sutFirst);
        SUT.setLastName(sutLast);
        SUT.setUsername();
        SUT.setEmail(sutEmail);
        SUT.setPassword(sutPassword);
        SUT.Save("TEST_MODE");
        Assert.assertTrue(User.Authenticate(SUT.getEmail(), SUT.getPassword(), "TEST_MODE"));
    }
    
    
    
    
    
}
