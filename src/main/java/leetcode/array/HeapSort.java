package leetcode.array;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] array){
        buildMaxHeap(array);
        for(int i = array.length-1; i>0; i--){
            adjustHeap(array, 0, i);
            int tmp=array[0];
            array[0]=array[i];
            array[i]=tmp;
        }
    }


    public static void buildMaxHeap(int[] array){
        for(int i = (array.length-1)/2 + 1; i>0; i--){
            adjustHeap(array, i, array.length-1);
        }
    }

    public static void adjustHeap(int[] array, int firstIndexNode, int lastIndexNode){
        int curNode = firstIndexNode;
        int leftChild = curNode*2+1;
        int rightChild = curNode*2+2;
        if(leftChild>lastIndexNode) return;
        //递归根据不同情况不断调整使父节点值大于两个孩子节点，若不满足则交换然后递归调整被交换的孩子节点
        if(rightChild<=lastIndexNode){
            if(array[leftChild]<array[rightChild] && array[curNode]<array[rightChild]){
                swap(array, curNode, rightChild);
                adjustHeap(array, rightChild, lastIndexNode);
                return;
            }
            if(array[leftChild]>array[rightChild] && array[curNode]<array[leftChild]){
                swap(array, curNode, leftChild);
                adjustHeap(array, leftChild, lastIndexNode);
                return;
            }
        }
        if(leftChild<=lastIndexNode){
            if(array[leftChild]>array[curNode]){
                swap(array, curNode, leftChild);
                adjustHeap(array, leftChild, lastIndexNode);
                return;
            }
        }

    }

    public static void swap(int[] array, int a, int b){
        int tmp=array[a];
        array[a]=array[b];
        array[b]=tmp;
    }

    public static void main(String[] args) {
        int[] a = {87,45,78,32,17,65,53,9,122,133};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

}
