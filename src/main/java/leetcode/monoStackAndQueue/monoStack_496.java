package leetcode.monoStackAndQueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class monoStack_496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums1.length];
        for(int i=nums2.length-1; i>=0; i--){
            while(!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                map.put(nums2[i], nums2[stack.peek()]);}
            stack.push(i);
        }
        for(int i=0; i<nums1.length; i++){
            res[i]=map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2}; int []nums2 = {1,3,4,2};
        int[] res = nextGreaterElement(nums1, nums2);
    }
}
