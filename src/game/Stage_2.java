/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fabian
 */
public class Stage_2 {
    
    private static String input = "6 5 8 1 4 5 2 7 3 12 4 17 3 19 1 24 1 26 2";
    private static int[][] game;
    private static Map<Integer, Integer> point = new HashMap<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] parts = input.split(" ");
        game = new int[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])];
        
        fill();
        
        int num = Integer.parseInt(parts[2]);
        int read = 3;
        for (int i = 0; i < num; i++) {
            point.put(Integer.parseInt(parts[read]), Integer.parseInt(parts[read+1]));
            read += 2;
        }
        System.out.println(point);
        int maxColor = point.keySet().stream().mapToInt(i -> i).max().getAsInt();
        System.out.println(point);
        
        for (int i = 1; i < maxColor; i++) {
            List<Integer> list = new ArrayList<>();
            for (int k : point.keySet()) {
                if (point.get(k) == i) {
                    list.add(k);
                }
            }
            
            search(list.get(0), list.get(1));
        }
    }

    private static void fill() {
        int index = 1;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                game[i][j] = index + j;
            }
            index += game[0].length;
        }
    }

    private static void search(int first, int second) {
        int sum = 0;
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                if (game[i][j] == first) {
                    x1 = i;
                    y1 = j;
                }
                if (game[i][j] == second) {
                    x2 = 1;
                    y2 = j;
                }
            }
        }
        sum += Math.abs((double)(y2-y1));
        sum += Math.abs((double)(x2-x1));
        System.out.println(" " + sum);
    }
}
