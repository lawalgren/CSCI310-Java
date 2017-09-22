/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework2;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Homework2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Homework2 app = new Homework2();
        app.run();
    }
    
    public void run()
    {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String newName = fix(name);
        System.out.println(newName);
    }
    
    public String fix(String name)
    {
        for (int i = 1; i < name.length(); i++)
        {
            if (name.charAt(i) == name.charAt(i-1)) {
                name = name.substring(0, i) + name.substring(i+1);
                i--;
            }   
        }
        return name;
    }
}
