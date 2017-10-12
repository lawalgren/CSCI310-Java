/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author Lucas
 */
public class Homework3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Homework3 app = new Homework3();
        app.run();
    }
    
    public void run()
    {
        
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
        
        doStuff(backwards, regular);
        outputThings(backwards, regular);
    }

    public void doStuff(TreeSet<thing> backwards, TreeSet<thing> regular) {
        backwards.remove(backwards.first());
        regular.remove(regular.first());
    }

    public void outputThings(TreeSet<thing> backwards, TreeSet<thing> regular) {
         for (thing item : backwards)
            System.out.println("Backwards:\nname: " + item.name + "\tboxes: " + item.boxes);
        for (thing item : regular)
            System.out.println("Unsorted:\nname: " + item.name + "\tboxes: " + item.boxes);
    }
    
}
