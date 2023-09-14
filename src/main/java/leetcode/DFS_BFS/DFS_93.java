package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class DFS_93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        DFS(res, path, s, 0, 0);
        return res;
    }

    public static void DFS(List<String> res, List<String> path, String s, int count, int startPos){
        if((count==4 && startPos!=s.length()) ||  (count<4 && startPos>=s.length())) return;
        if(count==4 && startPos==s.length()){
            StringBuilder sb = new StringBuilder();
            for(String ipPhrase: path){
               sb.append(ipPhrase);
               sb.append('.');
           }
            res.add(sb.substring(0, sb.length()-1));
        }
        if(startPos<s.length() && s.charAt(startPos)=='0'){
            path.add("0");
            DFS(res, path, s, count+1, startPos+1);
            path.remove(path.size()-1);
        }else{
            for(int curLen=1; curLen<=3; curLen++){
                if(startPos+curLen>s.length()) break;
                String curIP = s.substring(startPos, startPos+curLen);
                if( Integer.valueOf(curIP)>=0 && Integer.valueOf(curIP)<256){
                    path.add(curIP);
                    DFS(res, path, s, count+1, startPos+curLen);
                    path.remove(path.size()-1);
                }
            }
        }

    }
    public static void main(String[] args) {
        List<String> res1 = restoreIpAddresses("25525511135");
        List<String> res2 = restoreIpAddresses("0000");
        List<String> res3 = restoreIpAddresses("101023");
    }
}
