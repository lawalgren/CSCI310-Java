/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework2;

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
public class Homework2Test {
    
    public Homework2Test() {
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
     * Test of main method, of class Homework2.
     */
    @Test
    public void testMain() {
        System.out.println("Main: passed without testing");
    }

    /**
     * Test of run method, of class Homework2.
     */
    @Test
    public void testRun() {
        System.out.println("Run: passed without testing");
    }

    /**
     * Test of fix method, of class Homework2.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        String name = "boooooooooooob";
        Homework2 instance = new Homework2();
        String expResult = "bob";
        String result = instance.fix(name);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFix2() {
        System.out.println("fix");
        String name = "bob";
        Homework2 instance = new Homework2();
        String expResult = "bob";
        String result = instance.fix(name);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFix3() {
        System.out.println("fix");
        String name = "boooooobapalaxxxxios";
        Homework2 instance = new Homework2();
        String expResult = "bobapalaxios";
        String result = instance.fix(name);
        assertEquals(expResult, result);
    }
    
}
