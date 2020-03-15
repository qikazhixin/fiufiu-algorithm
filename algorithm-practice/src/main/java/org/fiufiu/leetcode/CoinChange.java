package org.fiufiu.leetcode;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class CoinChange {

    public static void main(String[] args) {
        CoinChange change = new CoinChange();
        System.out.println(change.coinChange(new int[]{1, 2, 5}, 11));
    }

    /*public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }*/


    public int coinChange(int[] coins, int amount) {
        counts=new int[amount+1];
        return coins(coins, amount);

    }

    private int[] counts;
    private int coins(int[] coins, int amount) {
        if(amount<0) {
            return -1;
        }
        if (amount==0) {
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int count1 = counts[amount];
        if (count1!=0) {
            return count1;
        }
        for (int i=0;i<coins.length;i++) {


            int coins1 = coins(coins, amount - coins[i]);
            if (coins1>=0&&coins1<min) {
                min=coins1+1;
            }
            min=min<= coins1 ?min:coins1;

        }
        counts[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return counts[amount];
    }
}
