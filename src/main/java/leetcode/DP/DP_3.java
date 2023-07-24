package leetcode.DP;

public class DP_3 {
    public static String longestPar(String s){
        boolean[][]dp = new boolean[s.length()][s.length()];
        char[] cs = s.toCharArray();
        int maxlen = 0; String res="";
        for(int i=cs.length-1; i>=0; i--){
            for(int j=i; j<=cs.length-1; j++){
                if(i==j || (i+1==j && cs[i]==cs[j]) || (j-i>1 && cs[i]==cs[j] && dp[i+1][j-1]==true)){
                    dp[i][j]=true;
                    if(j-i+1>maxlen){
                        maxlen=j-i+1;
                        res=s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String res = longestPar("sabbalk");
        String res1 = longestPar("babad");
        String res2 = longestPar("cbbd");
    }
}
