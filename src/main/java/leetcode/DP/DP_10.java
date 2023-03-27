package leetcode.DP;

public class DP_10 {
    //.*
    public static boolean matchPattern(String s, String t){
        boolean[][] dp = new boolean[s.length()+1][t.length()+1];
        dp[0][0]=true;dp[0][1]=false;dp[1][0]=false;
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=t.length(); j++){
                if(t.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(t.charAt(j-1)!='.'&&t.charAt(j-1)!='*'){
                    if(t.charAt(j-1)==s.charAt(i-1)) dp[i][j]=dp[i-1][j-1];
                    else dp[i][j]=false;
                }else {
                    if(t.charAt(j-2)!='.'){
                        if(t.charAt(j-2)==s.charAt(i-1)){
                            dp[i][j]=dp[i-1][j-2];
                        }else {
                            dp[i][j]=false;
                        }
                    }else {
                        for(int k=0; k<=i; k++){
                            if(dp[k][j-2]==true){
                                dp[i][j]= true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        boolean match = matchPattern("haordenn", ".*d*");
        System.out.println(match);
    }
}
