package leetcode.DP;

public class DP_322_518 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int i=1; i<=amount; i++){
            dp[i]=Integer.MAX_VALUE;
            for(int index=0; index<coins.length; index++){
                if(i-coins[index]>=0 && dp[i-coins[index]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i-coins[index]]+1, dp[i]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    //爬楼梯问题（1->2和2->1视为两种不同的方式，但换零钱(1，2)和(2，1)就是用一种组合,改变双循环顺序即可解决重复的问题！
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
//        for(int i=1; i<=amount; i++){
//            for(int index=0; index<coins.length; index++){
//                if(i-coins[index]>=0){
//                    dp[i]+=dp[i-coins[index]];
//                }
//            }
//        }
        for(int index=0; index<coins.length; index++){
          for(int i=1; i<=amount; i++){
              if(i-coins[index]>=0){
                    dp[i]+=dp[i-coins[index]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int res = change(5, new int[]{1,2,5});
        System.out.println(res);
    }
}
