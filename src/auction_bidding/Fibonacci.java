/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction_bidding;

/**
 *
 * @author Fabian
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    
    static int i1 = 0;
    static int i2 = 1;
    
    public static void main(String[] args) {
        int count = 0;
        System.out.println(count + " " + i1);
        count++;
        System.out.println(count + " " + i2);
        for (int i = 0; i < 50; i++) {
            int h = i1+i2;
            i1 = i2;
            i2 = h;
            System.out.println(++count + " " + i2);
        }
    }
}
