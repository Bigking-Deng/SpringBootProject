package leetcode;

import java.util.*;

public class Array_496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
           int []res =new int[nums1.length];
            Deque<Integer> stack = new LinkedList<>();
            Map<Integer, Integer> dict = new HashMap<>();
            for(int i = nums2.length -1; i>=0; i--){
                int nextElement = -1;
                while(!stack.isEmpty() && stack.peek()<nums2[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    nextElement = stack.peek();
                }
                dict.put(nums2[i], nextElement);
                stack.push(nums2[i]);
            }

            for(int i = 0; i<nums1.length; i++){
                res[i] = dict.get(nums1[i]);
            }

            return res;
        }
    }
}
