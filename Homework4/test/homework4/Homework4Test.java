/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class Homework4Test {

    public Homework4Test() {
    }

    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of main method, of class Homework4.
     */
    @Test
    public void testMain() {
        System.out.println("main untested");
    }

    /**
     * Test of getHash method, of class Homework4.
     */
    @Test
    public void testGetHash() {
        System.out.println("getHash");
        Long salt = (long) 1234;
        String password = "test";
        Homework4 instance = new Homework4();
        String expResult = "9e6d740cc865ba130f1f82c9e3274f56db042faa5e67c77e424cf1796d0814a407d9077de9cdad21fd3e198b2d49b3eb1df0ecf5b7864f741d9ea90cc226e8cd";
        String result = instance.getHash(salt, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of reset method, of class Homework4.
     */
    @Test
    public void testReset() {
        System.out.println("reset untested");
    }

    /**
     * Test of insertUser method, of class Homework4.
     */
    @Test
    public void testInsertUser() {
        System.out.println("insertUser untested");
    }

    /**
     * Test of getId method, of class Homework4.
     */
    @Test
    public void testGetId() {
        System.out.println("getId untested");
    }

    /**
     * Test of compareCredentials method, of class Homework4.
     */
    @Test
    public void testCompareCredentials() {
        System.out.println("compareCredentials");
        String username = "carrie";
        String password = "fa1rly$tr0ng";
        Homework4 instance = new Homework4();
        instance.reset();
        instance.insertUser(username, password);
        boolean expResult = true;
        boolean result = instance.compareCredentials(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCompareCredentials2() {
        System.out.println("compareCredentials");
        String username = "kevin";
        String password = "fa1rly$tr0ng";
        Homework4 instance = new Homework4();
        boolean expResult = false;
        boolean result = instance.compareCredentials(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCompareCredentials3() {
        System.out.println("compareCredentials");
        String username = "barry";
        String password = "fa1rly$tr0ng";
        Homework4 instance = new Homework4();
        boolean expResult = false;
        boolean result = instance.compareCredentials(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of run method, of class Homework4.
     */
    @Test
    public void testRun() {
        System.out.println("run untested");
    }

}
