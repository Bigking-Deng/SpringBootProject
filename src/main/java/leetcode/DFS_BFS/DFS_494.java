package leetcode.DFS_BFS;

public class DFS_494 {
    static int res;
    public int findTargetSumWays(int[] nums, int target) {
        res=0;
        DFS(nums, 0, 0, target);
        return res;
    }

    private static void DFS(int[] nums, int index, int sum, int target){
        if(index==nums.length){
            if(sum==target) res++;
        }
        int current = nums[index];
        DFS(nums, index+1, sum+current, target);
        DFS(nums, index+1, sum-current, target);
    }
}
