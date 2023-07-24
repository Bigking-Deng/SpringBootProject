package leetcode.monoStackAndQueue;


import java.util.Deque;
import java.util.LinkedList;


public class monoStack_84 {
    public static int maxHistogram(int []array){
        int left[] = new int[array.length];
        int right[] =new int[array.length];
        int maxRes = 0;
        Deque<Integer> stack = new LinkedList<>();
        //右侧最近的比自己小的元素从右向左遍历
        for(int i=array.length-1; i>=0; i--){
            while(!stack.isEmpty() && array[stack.peek()]>array[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i]=array.length;
            }else{
                right[i]=stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        //左侧最近的比自己小的元素从左向右遍历
        for(int i=0; i<array.length; i++){
            while(!stack.isEmpty() && array[stack.peek()]>array[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i]=-1;
            }else{
                left[i]=stack.peek();
            }
            stack.push(i);
        }
        for(int i=0; i<array.length; i++){
            int leftIndex = left[i]+1;
            int rightIndex = right[i]-1;
            int width = rightIndex - leftIndex +1;
            maxRes = Math.max(maxRes, width*array[i]);
        }
        return maxRes;
    }

    public static void main(String[] args) {
        int res = maxHistogram(new int[]{2,4});
    }
}
