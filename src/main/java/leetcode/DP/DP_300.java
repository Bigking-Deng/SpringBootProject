package leetcode.DP;

public class DP_300 {
    public static int logestSubSequence(int[] array){
        int[]dp = new int[array.length];
        dp[0]=1;
        for(int i=1; i<array.length; i++){
            int tmpMax=1;
            for(int tmp=0; tmp<i; tmp++){
                if(array[i]>array[tmp]){
                    if(dp[tmp]+1>tmpMax){
                        tmpMax=dp[tmp]+1;
                    }
                }
            }
            dp[i]=tmpMax;
        }
        return dp[array.length-1];
    }
    public static void main(String[] args) {
        int res = logestSubSequence(new int[]{10,9,2,5,3,7,101,18});
        int res1 = logestSubSequence(new int[]{0,1,0,3,2,3});
        int res2 = logestSubSequence(new int[]{7,7,7,7,7,7,7});
    }
}
