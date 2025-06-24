
import CoinChangeEx.CoinChangeAlgorithms;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Ex to view: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> runEx1();
            case 2 -> runEx2();
        }
    }
    public static void runEx1(){
        int[] coinsTest = {2,6,7};
        int amountTest = 18;
        System.out.println("For test case: coins=[2,6,7], amount = 18");
        System.out.println("Greedy solution:");
        System.out.println(CoinChangeAlgorithms.greedySolution(coinsTest, amountTest));
        System.out.println("Optimal solution:");
        System.out.println(CoinChangeAlgorithms.optimalSolution(coinsTest, amountTest));
        while (true){
            System.out.println("Run custom test case? 1 - Yes, 0 - No");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 0) {
                return;
            }
            System.out.println("Enter number of coins:");
            int[] coins = new int[sc.nextInt()];
            for (int i = 0; i < coins.length; i++) {
                System.out.println("Enter coin:");
                coins[i] = sc.nextInt();
            }
            System.out.println("Enter amount:");
            int amount = sc.nextInt();
            System.out.println("Greedy solution:");
            System.out.println(CoinChangeAlgorithms.greedySolution(coins, amount));
            System.out.println("Optimal solution:");
            System.out.println(CoinChangeAlgorithms.optimalSolution(coins, amount));
        }

    }
    public static void runEx2(){}
}