package leetcode.DP;

public class DP_312 {
    public int maxCoins(int[] nums) {
        int []balloonArray = new int [nums.length+2];
        balloonArray[0] = 1; balloonArray[nums.length+1] = 1;
        for(int i = 1; i <= nums.length; i++){
            balloonArray[i] = nums[i-1];
        }
        int dp[][] = new int[nums.length+2][nums.length+2];


        for(int i = nums.length+1; i>=0; i-- ){
            for(int j = i+2; j<=nums.length+1; j++){
                for(int k =i+1; k<j;k++){
                    dp[i][j] = Math.max(dp[i][j], balloonArray[k]*balloonArray[i]*balloonArray[j]+dp[i][k]+dp[k][j]);
                }

            }
        }

        return dp[0][nums.length+1];
    }
}
