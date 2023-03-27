package leetcode.twoPointer;

public class twoPointer_209 {
//    public static int minSubArrayLen(int target, int[] nums) {
//        int left=0, right=0, minSize=Integer.MAX_VALUE;
//        int sum=0;
//        while(right<nums.length){
//            while(right<nums.length && sum<target){
//                sum+=nums[right];
//                right++;
//            }
//            while(sum>=target){
//                minSize=Math.min(minSize, (right-1)-left+1);
//                sum-=nums[left];
//                left++;
//            }
//        }
//        return minSize==Integer.MAX_VALUE?0:minSize;
//    }

    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0, from = 0, win = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                win = Math.min(win, i - from + 1);
                sum -= nums[from++];
            }
        }
        return (win == Integer.MAX_VALUE) ? 0 : win;
    }

    public static void main(String[] args) {
        minSubArrayLen(7, new int[]{2,3,1,2,4,3});

    }
}
