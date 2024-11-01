package com.dynamicProgramming;

public class CoinChange1MaxNumberOfWays {
    public static void main(String[] args) {
        int coin[] = {1,2,3};
        int sum = 5;
        int n = coin.length;
        int t[][] = new int[n+1][sum+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=sum; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
                if (i > 0 && j > 0) {
                    if (coin[i-1] <= sum  ) {
                        int val1 = t[i][j-coin[i-1]];
                        int val2 = t[i-1][j];
                        t[i][j] = val1 + val2;
                    } else {
                        t[i][j] = t[i-1][j];
                    }
                }
            }
        }
        System.out.println("ans : " +t[n][sum]);
    }
}
