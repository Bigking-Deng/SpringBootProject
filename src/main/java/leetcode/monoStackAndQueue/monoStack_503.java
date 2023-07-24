package leetcode.monoStackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class monoStack_503 {
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i=2*nums.length-1; i>=0; i--){
            while(!stack.isEmpty()&&stack.peek()<=nums[i%nums.length]){
                stack.pop();
            }
            if(i<nums.length){
                if(!stack.isEmpty()){
                    res[i]=stack.peek();
                }
            }
            stack.push(nums[i%nums.length]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = nextGreaterElements(new int[]{1,2,3,4,3});
    }
}

