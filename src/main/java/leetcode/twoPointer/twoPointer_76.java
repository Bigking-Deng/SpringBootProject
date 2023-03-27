package leetcode.twoPointer;

import java.util.HashMap;
import java.util.Map;


public class twoPointer_76 {
    public static String minWindow(String s, String t) {
        String res="";
        Map<Character, Integer> dict = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
           dict.put(t.charAt(i), dict.getOrDefault(t.charAt(i), 0)+1);
        }
        int left=0, right = -1, minSize=Integer.MAX_VALUE;
        boolean flag = false;
        for(int i=0; i<s.length(); i++){
            left=i;
            while(right+1<s.length() && flag==false){
                right++;
                if(dict.containsKey(s.charAt(right))){
                    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
                }
                if(isValid(dict, map)){
                    flag=true;
                    break;
                }
            }
            if(flag==true){
                if(minSize>right-left+1){
                    minSize=right-left+1;
                    res=s.substring(left, right+1);
                }
            }
            if(dict.containsKey(s.charAt(left))){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
               if(isValid(dict, map)){
                   flag=true;
               }else{
                   flag=false;
               }
            }

        }
        return res;
    }

    private static boolean isValid(Map<Character, Integer> dict, Map<Character, Integer> map){
        for(Character key : dict.keySet()){
            if(map.getOrDefault(key, 0)<dict.get(key)){
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
}
