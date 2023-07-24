package leetcode.DP;

public class DP_72 {
    public static int minOpsNum(String s1, String t1){
        int[][] dp = new int[s1.length()+1][t1.length()+1];
        for(int i =1; i<=s1.length(); i++){
            dp[i][0]=i;
        }
        for(int j =1; j<=t1.length(); j++){
            dp[0][j]=j;
        }
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=t1.length(); j++){
                if(s1.charAt(i-1)==t1.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                }
            }
        }
        return dp[s1.length()][t1.length()];
    }

    public static void main(String[] args) {
        int res = minOpsNum("horse", "ros");
        int res1 = minOpsNum("intention", "execution");
    }
}
