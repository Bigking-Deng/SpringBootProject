package leetcode.permutation_combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class permutation_46 {
    static List<List<Integer>> result;
    public static List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        DFS_backtrace(nums, seen, new ArrayList<>(), 0);
        return result;
    }

    private static void DFS_backtrace(int[] nums, boolean[] seen, List<Integer> res, int ct){
        if(ct==nums.length){
            List<Integer> list = new ArrayList<>(res);
            result.add(list);
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(seen[i]==false){
                res.add(nums[i]);
                seen[i]=true;
                ct++;
                DFS_backtrace(nums, seen, res, ct);
                ct--;
                res.remove(res.size()-1);
                seen[i]=false;
            }
        }
    }

    private static void next_perm(int[] nums){
       int max=nums[nums.length-1];
       int maxIndex = nums.length -1;
       int point = maxIndex;
       while(point>0 && nums[point]>=max){
           point--;
           if(nums[point]>max){
               maxIndex=point;
           }
       }
       swap(nums, maxIndex, point);
       QuickSort(nums, maxIndex+1, nums.length-1);
    }

//    private static int binary_search(int[] nums, int target){
//        int left = 0; int right = nums.length-1;
//        while(left<right){
//            int mid = (right-left)/2+left;
//            if(nums[mid]==target){
//                return mid;
//            }else if(nums[mid]>target){
//                right=mid-1;
//            }
//            else {
//                left=mid+1;
//            }
//        }
//        if(left==right&&nums[left]==target) return left;
//        return -1;
//    }

    private static void QuickSort(int[] nums, int start, int end){
        if(end<=start) return;
        int rand = new Random().nextInt(end-start)+start;
        swap(nums, start, rand);
        int key = start;
        int i=start; int j=end;
        while(i<j){
            while(j>i && nums[j]>=nums[key]){
                j--;
            }
            while(j>i && nums[i]<=nums[key]){
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, key);
        QuickSort(nums, start, i-1);
        QuickSort(nums, i+1, end);
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,4,5,3};
        next_perm(nums);
//        permute(nums);
        System.out.println(result.size());
    }
}
