package WhyNotCoding;

import java.util.Arrays;

public class CoinsInCount {
    public static void main(String[] args) {
        int[] coins1 = {1 , 2 , 5} ;
        int[] coins2 = {2};
        int[] coins3 = {1};
        int amount1 = 11;
        int amount2 = 3;
        int amount3 = 2;

        System.out.println( coinChange(coins1 , amount1) );
        System.out.println( coinChange(coins2 , amount2) );
        System.out.println( coinChange(coins3 , amount3) );
    }

    public static int coinChange(int[] coins, int amount) {
        // array = amount + 1，default = amount + 1
        int max = amount + 1;
        int[] dptable = new int[amount + 1];
        Arrays.fill(dptable , max);
        //base case
        dptable[0] = 0 ;

        //all states
        for (int i = 1 ; i <= amount ; i++)
            //choose the smallest
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dptable[i] = Math.min(dptable[i] , dptable[i - coin] + 1);
            }


          //same idea
          /*  for (int j = 0 ; j < coins.length ; j++){
                if (coins[j] <= i)
                    dptable[i] = Math.min(dptable[i] , dptable[i - coins[j]] + 1);
            }*/


        return dptable[amount] > amount ? -1 : dptable[amount];
    }
}
