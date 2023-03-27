package leetcode.DP;

public class DP_664 {
    public int strangePrinter(String s) {
        char []ss = s.toCharArray();
        int [][]dp = new int [ss.length][ss.length];
        for(int i=0; i<ss.length; i++){
            dp[i][i] = 1;
        }
        for(int i=ss.length-1; i>=0; i--){
            for(int j=i+1; j<=ss.length-1; j++){
                if(ss[i]==ss[j]){
                    dp[i][j] = dp[i][j-1];
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);
                    }
                }


            }
        }
        return dp[0][ss.length-1];
    }
}
