/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3;

import java.util.Comparator;
import java.util.TreeSet;
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
public class Homework3Test {
    
    public Homework3Test() {
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
     * Test of main method, of class Homework3.
     */
    @Test
    public void testMain() {
        System.out.println("main untested");
    }

    /**
     * Test of run method, of class Homework3.
     */
    @Test
    public void testRun() {
        System.out.println("run untested");
    }

    /**
     * Test of doStuff method, of class Homework3.
     */
    @Test
    public void testDoStuff() {
        System.out.println("doStuff");
        Homework3 instance = new Homework3();
        TreeSet<thing> backwards = new TreeSet<thing> (new Comparator<thing> () {
            @Override
            public int compare(thing th1, thing th2) {
                return -th1.compareTo(th2);
            }
        });
        
        backwards.add(new thing("barry",7));
        backwards.add(new thing("harold", 55));
        backwards.add(new thing("richard", 2));
        backwards.add(new thing("angela", 19524));
        backwards.add(new thing("harold", 4));
        
        TreeSet<thing> regular = new TreeSet<thing> ();
        
        regular.add(new thing("barry",7));
        regular.add(new thing("harold", 55));
        regular.add(new thing("richard", 2));
        regular.add(new thing("angela", 19524));
        regular.add(new thing("harold", 4));
        instance.doStuff(backwards,regular);
        
        assertEquals(backwards.first(), new thing("harold", 55));
        backwards.remove(backwards.first());
        
        assertEquals(backwards.first(), new thing("barry", 7));
        backwards.remove(backwards.first());
        
        assertEquals(backwards.first(), new thing("harold", 4));
        backwards.remove(backwards.first());
        
        assertEquals(backwards.first(), new thing("richard", 2));
        backwards.remove(backwards.first());
        
        assertEquals(regular.first(), new thing("harold", 4));
        regular.remove(regular.first());
        
        assertEquals(regular.first(), new thing("barry", 7));
        regular.remove(regular.first());
        
        assertEquals(regular.first(), new thing("harold",55));
        regular.remove(regular.first());
        
        assertEquals(regular.first(), new thing("angela", 19524));
        regular.remove(regular.first()); 
    }

    /**
     * Test of outputThings method, of class Homework3.
     */
    @Test
    public void testOutputThings() {
        System.out.println("outputThings untested");
    }
    
}
