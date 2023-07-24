package leetcode.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class slidingWindow_3 {

    public static String maxSubstr(String s){
        int max = 0; String maxStr = "";
        char[] cs = s.toCharArray();
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while(right<cs.length){
            if(!set.contains(cs[right])){
                set.add(cs[right]);
                if(right - left +1 > max){
                    max = right - left +1;
                    maxStr = s.substring(left, right+1);
                }
            }else{
                while(left<=right && set.contains(cs[right])){
                    set.remove(cs[left]);
                    left++;
                }
                set.add(cs[right]);
            }
            right++;
        }
        return maxStr;
    }



    public static void main(String[] args) {
        String res = maxSubstr("djaadmnadhaldj");
    }
}
