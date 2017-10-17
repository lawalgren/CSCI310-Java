/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3;

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
public class thingTest {
    
    public thingTest() {
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
     * Test of compareTo method, of class thing.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        thing o = new thing("freddie", 7);
        thing instance = new thing("gerald", 64);
        int expResult = 1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo");
        thing o = new thing("freddie", 0);
        thing instance = new thing("gerald", 0);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCompareTo3() {
        System.out.println("compareTo");
        thing o = new thing(" ", 92);
        thing instance = new thing("", 15);
        int expResult = -1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCompareTo4() {
        System.out.println("compareTo");
        Integer o = new Integer(7);
        thing instance = new thing("gerald", 64);
        int result = instance.compareTo(o);
        assertTrue(result < 0);
    }
}
