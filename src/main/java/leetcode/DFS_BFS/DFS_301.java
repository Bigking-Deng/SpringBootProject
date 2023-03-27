package leetcode.DFS_BFS;

import java.util.*;

public class DFS_301 {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        List<String> res = new ArrayList<>();
        q.add(s);
        visited.add(s);
        int flag = 0;
        while(!q.isEmpty()){
            if(flag==1) break;
            int size = q.size();
            for(int i=0; i<size; i++){
                String cur = q.poll();
                if(isValid(cur)){
                    flag=1;
                    if(!res.contains(cur)){
                        res.add(cur);
                    }
                    continue;
                }
                for(int j=0; j<cur.length(); j++){
                    String next = cur.substring(0,j)+cur.substring(j+1);
                    if(!visited.contains(next)){
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
        }
        return res;
    }

    private static boolean isValid(String s){
        char[] c = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<c.length; i++){
            if(c[i]!='(' && c[i]!=')') continue;
            else if(c[i]=='(') stack.push(c[i]);
            else if(c[i]==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }
            else return false;
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        boolean flag = isValid("(a))()");
    }
}
