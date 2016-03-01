/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import Core.Database.ConnectionManager;
import Core.Database.Settings;
import org.junit.Assert;
/**
 *
 * @author andrewclawson
 */
public class ConnectionManagerTest {
    public static ConnectionManager SUT;
    public static Settings settings;
    public ConnectionManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        SUT = new ConnectionManager();
        settings = new Settings();
    }
    
    @Test
    public void ConnectionManagerHasCorrectHost(){
        String expectedHost = settings.host;
        Assert.assertEquals(expectedHost,SUT.host);
    }
    
    @Test
    public void ConnectionManagerHasCorrectUsername(){
        String expectedUsername = settings.username;
        Assert.assertEquals(expectedUsername,SUT.userName);
    }
    
    @Test
    public void ConnectionManagerHasCorrectPassword(){
        String expectedPassword = settings.password;
        Assert.assertEquals(expectedPassword,SUT.password);
    }
    
    @Test
    public void DefaultConnectionIsNotNull(){
        Assert.assertNotNull(SUT.connection);
    }
    
    
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
}
