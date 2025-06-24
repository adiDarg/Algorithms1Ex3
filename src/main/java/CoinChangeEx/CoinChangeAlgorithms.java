package CoinChangeEx;

import java.util.Arrays;

public class CoinChangeAlgorithms {
    public static int greedySolution(int[] coins, int amount) {
        int result = 0;
        Arrays.sort(coins);
        //Coins are sorted in ascending order, so I am starting from the largest value by starting from the end
        for (int i = coins.length - 1; i >= 0 ; i--){
            if (coins[i] <= 0){
                continue;
            }
            if (coins[i] <= amount){
                amount -= coins[i];
                result++;
                i++; //Repeat the same coin until too large
            }
            if (amount == 0){
                break;
            }
        }
        if (amount != 0){
            return -1;
        }
        return result;
    }
    public static int optimalSolution(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int[] amounts = new int[amount + 1]; //Array containing optimal number of coins to reach each sum(Ex: amounts[5] = optimal number of coins to reach sum 5)
        for (int i = 1; i < amounts.length; i++){
            amounts[i] = Integer.MAX_VALUE - 1; //Initialize to MAX_VALUE(Practically infinity)
        }
        for (int coin : coins) {
            if (coin <= 0){
                continue;
            }
            amounts[coin] = 1; //Ex: if we have coin 5 than sum 5 can be reached instantly
            for (int j = 0; j < amounts.length; j++) { //j = current amount being checked(What's the best way to get to sum X)
                //Going over
                if (coin + j > amount) {
                    break;
                }
                //Unreachable
                if (amounts[j] == Integer.MAX_VALUE - 1) {
                    continue;
                }
                amounts[j + coin] = Math.min(amounts[j + coin], amounts[j] + 1); //If we add current coin to our current amount, will it be optimal?
            }
        }
        //If we couldn't reach the amount at all with the available coins
        if (amounts[amount] == Integer.MAX_VALUE - 1){
            return -1;
        }
        return amounts[amount];
    }
}
