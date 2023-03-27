package leetcode.permutation_combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_77 {
    private static List<List<Integer>> result;
    private static void comb_with_dulplicate(int[] nums, int k){
        Arrays.sort(nums);
        result = new ArrayList<>();
//        boolean[] seen = new boolean[nums.length];
        DFS_backtrace(nums, 0, k, new ArrayList<>());
    }


    private static void DFS_backtrace(int[] nums,  int start, int k, List<Integer> list){
        if(start>=nums.length && list.size()<k) return;
        if(list.size()==k){
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(i==start||(nums[i]!=nums[i-1])){
                list.add(nums[i]);
                DFS_backtrace(nums, i+1, k, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3, 3, 4};
        comb_with_dulplicate(nums, 2);
        System.out.println(result.size());
    }
}
