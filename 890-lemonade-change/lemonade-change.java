class Solution {
    // here the greedy algorithm is where we try to save 5 when we got 20$ 
    // suppose a person came with 20 then we first try to give them a 10 and a 5$ and if are unable to do then we given three 5 Rs change so that is how we save 5 for the future customer 
    // For $20, consume the larger denomination ($10) first and preserve $5 bills.
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i=0; i<bills.length; i++) {
            if(bills[i] == 5) {
                five += 1;
            }else if(bills[i] == 10) {
                if(five>0) {
                    ten += 1;
                    five -= 1;
                }else { 
                    return false;
                }
            }else {
                if(ten > 0 && five > 0) {
                    ten -= 1;
                    five -= 1;
                }else if(five >= 3) {
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}