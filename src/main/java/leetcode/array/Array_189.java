package leetcode.array;

public class Array_189 {
    public static void rotate(int[] nums, int k){
        int count=0;
        int startPos = -1;
        while(count<nums.length){

            int nextValue=0;
            startPos++;
            int curIndex = startPos;
            int preValue = nums[startPos];
            while(true){
                count++;
                curIndex=(curIndex+k)%nums.length;
                nextValue=nums[curIndex];
                nums[curIndex]=preValue;
                preValue=nextValue;
                if(curIndex==startPos) break;
            }


        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        rotate(array, 12);
    }

}
