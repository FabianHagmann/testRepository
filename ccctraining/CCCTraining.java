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
public class CCCTraining {
    private static int bid = 0, bidMax = 0, buyInstant = -1;
    private static String bidder = "-";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] tokens = line.split(",");
        int index = 0;
        bid = Integer.parseInt(tokens[index++]);
        buyInstant = Integer.parseInt(tokens[index++]);
        bidMax = bid;
        
        System.out.print(bidder + "," + bid + ",");
        
        //Erstes Gebot
        while(bidder.compareTo("-") == 0){
            String lastBidder = bidder;
            String first = tokens[index++];
            int firstBid = Integer.parseInt(tokens[index++]);
            if(firstBid >= bid){
                bidMax = firstBid;
                bidder = first;
            }
            if(bidder.compareTo(lastBidder) != 0){
                System.out.print(bidder + "," + bid+ ",");
            }
        }
        
        while(index < tokens.length - 1){
            int lastBid = bid;
            String now = tokens[index++];
            int nowBid = Integer.parseInt(tokens[index++]);
            if(buyInstant != 0 && now.compareTo(bidder) != 0 && bidMax >= buyInstant){
                if(nowBid >= buyInstant - 1){
                    System.out.println(bidder+","+buyInstant);
                    break;
                }
            }
            if(bidder.compareTo(now) == 0){
                bidMax = nowBid;
            }else if(nowBid > bidMax){
                bid = bidMax + 1;
                bidMax = nowBid;
                bidder = now;
            }else if(nowBid == bidMax){
                bid = bidMax;
            }else{
                bid = nowBid + 1;
            }
            if(bid != lastBid){
                System.out.print(bidder + "," + bid+ ",");
            }
        }
        System.out.println("");
    }
    
}
