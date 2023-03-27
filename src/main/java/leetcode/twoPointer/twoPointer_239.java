package leetcode.twoPointer;

import java.util.TreeMap;

public class twoPointer_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //使用TreeMap的key保存数的值，而value保存此数目前最右边的下标（可能有重复）所以选取当前在窗口内的最右边的下标
        //利用treemap的自动维护排序的特性去选取最大值，并能在移除左边值的同时判断窗口内是否还有相等的最大值
        if(k>nums.length){
            int max = 0;
            for(int i=0; i<nums.length; i++){
                max=Math.max(max, nums[i]);
            }
            return new int[]{max};
        }
        int[] res = new int[nums.length-k+1];
        TreeMap<Integer, Integer> map = new TreeMap();
        int left=0; int right=k-1; int point=0;
        for (int i=0; i<k; i++){
            map.put(nums[i], i);
        }
        res[point]=map.lastKey();
        while(right+1<nums.length){
            if(map.get(nums[left])==left){
                map.remove(nums[left]);
            }
            left++;
            right++;
            map.put(nums[right], right);
            point++;
            res[point]=map.lastKey();
        }
        return res;
    }

//类似用优先队列解决此问题
//    class Solution {
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            int n = nums.length;
//            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
//                public int compare(int[] pair1, int[] pair2) {
//                    return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
//                }
//            });
//            for (int i = 0; i < k; ++i) {
//                pq.offer(new int[]{nums[i], i});
//            }
//            int[] ans = new int[n - k + 1];
//            ans[0] = pq.peek()[0];
//            for (int i = k; i < n; ++i) {
//                pq.offer(new int[]{nums[i], i});
//                while (pq.peek()[1] <= i - k) {
//                    pq.poll();
//                }
//                ans[i - k + 1] = pq.peek()[0];
//            }
//            return ans;
//        }
//    }



    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
