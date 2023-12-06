package leetcode.array;

public class Array_45_55 {

    public boolean canJump(int[] nums) {
        int start=0; int end=nums[0]+0;
        while(end<nums.length-1){
            int curMax=0;
            for(int i=start; i<=end; i++){
                curMax=Math.max(curMax, nums[i]+i);
            }
            if(curMax>=nums.length-1) return true;
            if(curMax<=end) return false;
            start=end;
            end=curMax;
        }
        return true;
    }

    public int minJump(int[] nums) {
        int start=0; int end=nums[0]+0;
        int step = 1;
        while(end<nums.length-1){
            step++;
            int curMax=0;
            for(int i=start; i<=end; i++){
                curMax=Math.max(curMax, nums[i]+i);
            }
            if(curMax>=nums.length-1) return step;
            if(curMax<=end) return-1;
            start=end;
            end=curMax;
        }
        return step;
    }

}
