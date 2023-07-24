package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class slidingWindow_76 {
    public static String minSubStr(String parent, String child){
        int minLen = Integer.MAX_VALUE; String substr = "";
        int left=0; int right=0;
        Map<Character, Integer> dict = new HashMap<>();
        Map<Character, Integer> curMap = new HashMap<>();
        for(int i =0; i<child.length(); i++){
            dict.put(child.charAt(i), dict.getOrDefault(child.charAt(i), 0)+1);
        }
        char[] cs = parent.toCharArray();
        while(right<cs.length){

            curMap.put(cs[right], curMap.getOrDefault(cs[right], 0)+1);

            while(left<=right && checkValid(curMap, dict)){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    substr=parent.substring(left, right+1);
                }
                curMap.put(cs[left], curMap.get(cs[left])-1);
                left++;
            }
            right++;

        }
        return substr;
    }

    public static boolean checkValid(Map<Character, Integer> cur, Map<Character, Integer> dict){
        for(Character c: dict.keySet()){
            if(cur.getOrDefault(c, 0)<dict.get(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String res = minSubStr("djaadmnadhaldj", "aln");
    }
}
