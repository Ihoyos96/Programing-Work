package Exercises;
/* Dynamic Programming Java implementation of Coin
   Change problem */
import java.util.Arrays;
 
class DynamicPrograming1
{
	public static long waysToChange(int[] coins, int coinTypes, int sum){
        
        long[] table = new long[sum + 1];
        table[0] = 1;
        for (int coin : coins)
            for (int i = coin; i <= sum; i++){
                table[i] += table[i - coin];
            }
        return table[sum];
    }
 
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(waysToChange(arr, m, n));
    }
}
