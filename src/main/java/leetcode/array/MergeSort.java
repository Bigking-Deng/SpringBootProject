package leetcode.array;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MergeSort {
    public static void mergeSort(int[] array){
        mergeAndSort(array, 0, array.length-1);
    }

    public static void mergeAndSort(int[] array, int start, int end){
        if(start>=end) return;
        int mid = (end - start)/2 + start;
        mergeAndSort(array, start, mid);
        mergeAndSort(array, mid+1, end);
        int[] afterMergeArray = new int[end-start+1];
        int l1 = start, r1 = mid, l2 = mid+1, r2 = end, point1 = l1, point2 = l2, mergedPoint = 0;
        while(point1<=r1 && point2<=r2){
            if(array[point1]<=array[point2]){
                afterMergeArray[mergedPoint]=array[point1];
                point1++;
            }else{
                afterMergeArray[mergedPoint]=array[point2];
                point2++;
            }
            mergedPoint++;
        }
        while(point1<=r1){
            afterMergeArray[mergedPoint++]=array[point1++];
        }
        while(point2<=r2){
            afterMergeArray[mergedPoint++]=array[point2++];
        }
        for(int idx=start; idx<=end; idx++){
            array[idx]=afterMergeArray[idx-start];
        }
    }

    public static void main(String[] args) {
        int[] array = {4,4,2,94,5,49,0,8,24,65,9,12};
        mergeSort(array);
    }
}
