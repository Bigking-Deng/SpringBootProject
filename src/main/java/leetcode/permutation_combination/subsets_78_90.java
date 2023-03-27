package leetcode.permutation_combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets_78_90 {
    private static List<List<Integer>> result;
    private static void subsets_with_dulplicate(int[] nums){
        Arrays.sort(nums);
        result = new ArrayList<>();
        result.add(new ArrayList<>());
//        boolean[] seen = new boolean[nums.length];
        DFS_backtrace(nums, 0, new ArrayList<>());
    }


    private static void DFS_backtrace(int[] nums,  int start, List<Integer> list){
        if(start>=nums.length) return;
        for(int i=start; i<nums.length; i++){
            if(i==start||(nums[i]!=nums[i-1])){
                list.add(nums[i]);
                List<Integer> temp = new ArrayList<>(list);
                result.add(temp);
                DFS_backtrace(nums, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,4};
        subsets_with_dulplicate(nums);
        System.out.println(result.size());
    }

}
