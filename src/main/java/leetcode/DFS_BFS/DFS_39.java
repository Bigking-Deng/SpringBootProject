package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(res, list, candidates, target, 0,0);
        return res;
    }

    public static void DFS(List<List<Integer>> res, List<Integer> curPath, int[] candidates, int target, int curSum, int startPos){
        if(curSum==target){
            List<Integer> newArray = new ArrayList<>(curPath);
            res.add(newArray);
            return;
        }
        for(int i=startPos; i<candidates.length; i++){
            if(candidates[i]+curSum>target) break;
            curPath.add(candidates[i]);
            DFS(res, curPath, candidates, target, curSum+candidates[i], i);
            curPath.remove(curPath.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,6,7}; //target = 7
        int[] array1 = new int[]{2,3,5};//target = 8
        int[] array2 = new int[]{2};//target = 1
        List<List<Integer>> l1 = combinationSum(array, 7);
        List<List<Integer>> l2 =combinationSum(array1, 8);
        List<List<Integer>> l3 =combinationSum(array2, 1);
    }
}
