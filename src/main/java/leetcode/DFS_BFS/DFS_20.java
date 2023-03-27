package leetcode.DFS_BFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DFS_20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char []array = s.toCharArray();
        int num = 0;
        while(num<s.length()){
            if(array[num]=='('||array[num]=='['||array[num]=='{'){
                stack.push(array[num]);
            }else if(!stack.isEmpty()&&((array[num]==')'&&stack.peek()=='(')||(array[num]==']'&&stack.peek()=='[')||(array[num]=='}'&&stack.peek()=='{'))){
                stack.pop();
            }else{
                stack.push(array[num]);
            }
            num++;
        }
        if(stack.isEmpty()) return true;
        return false;

    }
}
