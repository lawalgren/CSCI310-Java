/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplication1;

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
public class TestApplication1Test {
    
    public TestApplication1Test() {
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
     * Test of getArea method, of class TestApplication1.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        double length = 0.0;
        double width = 0.0;
        TestApplication1 instance = new TestApplication1();
        double expResult = 0.0;
        double result = instance.getArea(length, width);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getArea method, of class TestApplication1.
     */
    @Test
    public void testGetArea2() {
        System.out.println("getArea");
        double length = 7.3;
        double width = 6.0;
        TestApplication1 instance = new TestApplication1();
        double expResult = 43.8;
        double result = instance.getArea(length, width);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getArea method, of class TestApplication1.
     */
    @Test
    public void testGetArea3() {
        System.out.println("getArea");
        double length = 1584.0293;
        double width = 0.99984769515639123915701155881391;
        TestApplication1 instance = new TestApplication1();
        double expResult = 1583.7880446651918050880136095999;
        double result = instance.getArea(length, width);
        assertEquals(expResult, result, 1e-14);
    }
    
}
