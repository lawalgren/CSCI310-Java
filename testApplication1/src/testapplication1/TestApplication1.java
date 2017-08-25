/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplication1;

/**
 *
 * @author Lucas
 */
public class TestApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TestApplication1 app = new TestApplication1();
        app.run();
    }
    
    public void run()
    {
        double length = 50.0;
        double width = 30.0;
        double area = getArea(length, width);
        System.out.println("Area of rectangle = " + area);
    }
    
    public double getArea(double length, double width)
    {
        double area = length * width;
        return area;
    }
    
}
