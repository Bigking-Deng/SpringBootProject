package leetcode.slidingWindow;

public class slidingWindow_209 {
    public static int minLength(int[] array, int target){
        int sum = 0; int minLen = Integer.MAX_VALUE;
        int left = 0; int right = 0;
        while(right<array.length){
            sum=sum+array[right];
            while(left<=right && sum>=target){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                }
                sum=sum-array[left];
                left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }

    public static void main(String[] args) {
        int res = minLength(new int[]{2,3,1,2,4,3}, 7);
        int res1 = minLength(new int[]{1,4,4}, 1);
        int res2 = minLength(new int[]{1,1,1,1}, 7);
    }
}
