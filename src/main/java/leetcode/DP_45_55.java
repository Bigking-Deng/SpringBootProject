package leetcode;

public class DP_45_55 {
    private static boolean jump1(int arr[]){
        boolean isPoss[] = new boolean [arr.length];
        isPoss[0] = true;
        for(int k =0; k<arr.length; k++){
            for(int j = 0; j<k; j++){
                if(isPoss[j]==true && arr[j]>=k-j){
                    isPoss[k]=true;
                    break;
                }
            }
        }
        return isPoss[arr.length -1];
    }

    private static int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}

