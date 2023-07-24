package leetcode.slidingWindow;

import java.util.Collections;

public class slidingWindow_1004 {
    public static int maxLength(int[] array, int opsNum){

       int left=0; int right=0;
       int sum=0; int maxlen=0;
       while(right<array.length){
           sum=sum+array[right];
           if(sum>=right-left+1-opsNum){
               maxlen=Math.max(maxlen, right-left+1);
           }
           while(left<=right && sum<right-left+1-opsNum){
               sum=sum-array[left];
               left++;
           }
           right++;

       }
       return maxlen;
    }

    public static void main(String[] args) {
        int res=maxLength(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
        int res1=maxLength(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
    }
}
