package leetcode;

public class binary_search_33_153 {
    public static Integer pivotIndex(int [] array){
        int length = array.length;
        int init = array[0];
        if(length == 0 || length == 1) return -1;
        int left = 0, right = length -1;
        int mid, result;
        while( left < right){
            mid = left + (right - left )/2;
            if(array[mid] > array[ mid +1 ]){
                return mid+1;
            }
            else if(array[mid] < array[ mid +1 ] && array[mid] < init){
                right = mid;
            }
            else {
                left = mid +1;
            }
        }

        return -1;
    }

    public static Integer pivotIndex_min(int [] array){
        if(binary_search_33_153.pivotIndex(array) == -1) return array[0];
        int index = binary_search_33_153.pivotIndex(array);
        return array[index];
    }

    public static void main(String[] args) {
        int X = binary_search_33_153.pivotIndex(new int[]{1,2});
        int Y = binary_search_33_153.pivotIndex_min(new int[]{1,2});
        System.out.println( X+" "+ Y);
    }
}
