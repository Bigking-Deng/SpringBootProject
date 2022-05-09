package leetcode;

public class Array_75 {

//    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//    You must solve this problem without using the library's sort function. one pass algorithm and extra constant space

    private static void swap(int a, int b, int[]array){
        int temp;
        temp =array[a];
        array[a] = array[b];
        array[b] =temp;
    }

    private static void sortColor(int[] array){
        int head = 0, tail = array.length -1, pt = 0;
        while(pt<tail){
            if(array[pt]==0){
                swap(head, pt, array);
                head++;
                pt++;
            }
            else if(array[pt]==2){
                swap(pt, tail, array);
                tail--;
            }
            else{
                pt++;
            }
        }
    }

    public static void main(String[] args) {
        int array[] ={1,0,0,2,2,1,0,2};
        sortColor(array);
    }

}
