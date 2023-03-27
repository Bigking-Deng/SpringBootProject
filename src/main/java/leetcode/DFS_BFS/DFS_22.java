package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.sf.jsqlparser.parser.feature.Feature.set;

public class DFS_22 {
   static List<String> res;
    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n==0) return res;
        DFS("(",0,n-1,n,n);
        return res;
    }

    private static void DFS(String s, int pairs, int l_remain, int r_remain, int n){
        if(pairs==n&&l_remain==0&&r_remain==0){
            res.add(s);
        }
        if(s.charAt(s.length()-1)=='('){
            if(l_remain>0){
                DFS(s+'(', pairs, l_remain-1, r_remain,n);
                DFS(s+')', pairs+1, l_remain, r_remain-1,n);
            }
            else{
                DFS(s+')', pairs+1, l_remain, r_remain-1,n);
            }
        }
        if(s.charAt(s.length()-1)==')'){
            if(l_remain<r_remain){
                if(l_remain>0){
                    DFS(s+'(', pairs, l_remain-1, r_remain,n);
                }
                DFS(s+')', pairs+1, l_remain, r_remain-1,n);
            }
            else {
                if(l_remain>0)
                    DFS(s+'(', pairs, l_remain-1, r_remain,n);

            }
        }
    }

    public static void main(String[] args) {
        generateParenthesis(5);
    }
}
