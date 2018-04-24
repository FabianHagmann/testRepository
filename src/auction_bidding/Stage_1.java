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
public class Stage_1 {
        
    private static int bid = 0;
    private static String bidder = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "1,cable,5,ente,10,karl,19,moehe,23,michbex,24,melloy,29,achi,26";
        String[] parts = input.split(",");
        
        int index = 2;
        bid = Integer.parseInt(parts[0]);
        
        while (parts.length >= index) {
            String akt_bidder = parts[index-1];
            int akt_bid = Integer.parseInt(parts[index]);
            
            if (akt_bid > bid) {
                bid = akt_bid;
                bidder = akt_bidder;
            }
            
            index += 2;
        }
        System.out.println(bidder + "," + bid);
    }
    
}
