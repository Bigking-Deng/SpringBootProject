package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS_491 {
    static Set<List<Integer>> result;
    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new HashSet<>();
        if(nums.length==0) return new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            List<Integer> path = new ArrayList<>();
            DFS(nums, i, path);
        }
//        for(List<Integer> list:result){
//            res.add(list);
//        }
        List<List<Integer>> res = new ArrayList<>(result);
        return res;
    }

    private static void DFS(int[] nums, int index, List<Integer> path){

        if(index>=nums.length) return;
        int cur = nums[index];
        path.add(cur);
        for(int i = index+1; i<nums.length; i++){
            if(nums[i]>=cur){
                DFS(nums, i, path);
            }
        }
        if(path.size()>1) result.add(new ArrayList<>(path));
        path.remove(path.size()-1);
    }


//    public List<List<Integer>> findSubsequences(int[] a) {
//        Set<List<Integer>> r = new HashSet<>();
//        find(0, a, new LinkedList<>(), r);
//        return new ArrayList<>(r);
//    }
//
//    void find(int start, int[] a, LinkedList<Integer> list, Set<List<Integer>> r) {
//        if (list.size() >= 2)
//            r.add(new ArrayList<>(list));
//        for (int i = start; i < a.length; i++)
//            if (list.isEmpty() || list.getLast() <= a[i]) {
//                list.add(a[i]);
//                find(i + 1, a, list, r);
//                list.removeLast();
//            }
//    }
}
