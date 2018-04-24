/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccctraining;

import java.util.Scanner;

/**
 *
 * @author Jürgen Geyer
 */
public class Fibonacci {
    private static int first = 0;
    private static int last = 1;
    public static void main(String[] args) {
        int count = new Scanner(System.in).nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println(last);
            last += first;
            first = last - first;
        }
    }
}
