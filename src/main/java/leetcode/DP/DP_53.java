package leetcode.DP;

public class DP_53 {
    public static int maxSumArray(int[] array){
        int[] dp = new int[array.length];
        dp[0]=array[0]; int max=array[0];
        for(int i=1; i<array.length; i++){
            if(dp[i-1]<0){
                dp[i]=array[i];
            }else{
                dp[i]=dp[i-1]+array[i];
            }
            max=Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int res = maxSumArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        int res1 = maxSumArray(new int[]{1});
        int res2 = maxSumArray(new int[]{5,4,-1,7,8});
    }
}
