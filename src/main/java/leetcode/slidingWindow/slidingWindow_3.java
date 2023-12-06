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

            //第一种方法
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


            //第二种方法
//            while(right<s.length() && !set.contains(s.charAt(right))){
//                set.add(s.charAt(right));
//                if(right-left+1>max){
//                    max=right-left+1;
//                    // maxStr=s.substring(left, right+1);
//                }
//                right++;
//            }
//            while(left<right && right<s.length() && set.contains(s.charAt(right))){
//                set.remove(s.charAt(left));
//                left++;
//            }

            //第三种方法
//            while(set.contains(right)){
//                set.remove(s.charAt(left));
//                left++;
//            }
//            set.add(s.charAt(right));
//            max = Math.max(max, right-left+1);
//            right++;
        }
        return maxStr;
    }



    public static void main(String[] args) {
        String res = maxSubstr("djaadmnadhaldj");
    }
}
