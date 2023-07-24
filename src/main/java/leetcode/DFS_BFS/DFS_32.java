package leetcode.DFS_BFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFS_32 {
    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static int longestValidParenthesesDP(String s){
        int maxLen = 0;
        int[] dp = new int[s.length()];
        dp[0]=0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=2+(i>=2?dp[i-2]:0);
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=2+dp[i-1]+(i-dp[i-1]>=2?dp[i-2-dp[i-1]]:0);
                }
                maxLen=Math.max(maxLen, dp[i]);
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int res = longestValidParenthesesDP(")()())");
        int res1= longestValidParenthesesDP(")()(()())");
        int res2 = longestValidParenthesesDP("(())()(()))(");
    }


}
