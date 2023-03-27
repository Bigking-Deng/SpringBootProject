package leetcode.twoPointer;

import java.util.HashMap;
import java.util.Map;

public class twoPointer_340 {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left=0, right=0, res=0;
        Map<Character, Integer> map = new HashMap<>();
        while(right<s.length()){

            while(right<s.length() && !((map.size()==k && !map.containsKey(s.charAt(right))) || map.size()>k)){
                res=Math.max(res, right-left+1);
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }
            if(right<s.length()){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstringKDistinct("ecebaacbbee", 3);
    }
}
