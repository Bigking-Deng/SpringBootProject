package leetcode.DP;

public class DP_44 {
    /*

     */

    public static boolean matchPattern(String s, String t){
        boolean[][] dp = new boolean[s.length()+1][t.length()+1];
        dp[0][0] = true; dp[1][0] = false;
        if(t.charAt(0)=='*') dp[0][1] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=t.length(); j++){
                if(t.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(t.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];

                }else {
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }else {
                        dp[i][j]=false;
                    }

                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        boolean bb = matchPattern("acdcb", "a?c*b");
        System.out.println(bb);
    }
}
