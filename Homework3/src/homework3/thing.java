/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3;

/**
 *
 * @author Lucas
 */
public class thing implements Comparable {
    int boxes;
    String name;
    
    thing(String _name, int _boxes)
    {
        boxes = _boxes;
        name = _name;
    }
    
    thing()
    {
        boxes = 0;
        name = "";
    }

    @Override
    public int compareTo(Object o) {
    if(o instanceof thing) {
        thing other = (thing) o; 
        if (boxes == other.boxes)
            return 0;
        else if (boxes < other.boxes)
            return -1;
        else
            return 1;
    }
    else
        return this.getClass().getName().compareTo(o.getClass().getName());
    }
    
    @Override
    public boolean equals(Object o) {
        return (this.compareTo(o) == 0);
    }
}
