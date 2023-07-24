package leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class Array_503 {

//    1,2,5,3,4,  1,2,5,3,4
//    a[i] = a[i+5] = a[i+10] =...= a[i+5k]--> a[i]=a[(i+5k)%5]
        public int[] nextGreaterElements(int[] nums) {

            int lastIndexOfNewArray = 2*nums.length-1;
            int recordIndex = nums.length-1;
            Deque<Integer> stack = new LinkedList<>();
            int[] res = new int[nums.length];
            for(int i=lastIndexOfNewArray; i>=0; i--){
                int nextElement = -1;
                while(!stack.isEmpty() && nums[i%nums.length] >= stack.peek()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    nextElement = stack.peek();
                }
                if(i<=recordIndex){
                    res[i] = nextElement;
                }
                stack.push(nums[i%nums.length]);
            }
            return res;
        }

}
