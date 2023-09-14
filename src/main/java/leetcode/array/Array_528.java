package leetcode.array;

import java.util.Random;

public class Array_528 {

    static int[] probabaility;
    public static void Solution(int[] w) {
        probabaility = new int[w.length+1];
        int curSum = 0;
        for(int i=0; i<w.length; i++){
            curSum+=w[i];
            probabaility[i+1]=curSum;
        }
    }

    public static int pickIndex() {
        int res=0;
       Random random = new Random();
       int x = random.nextInt(probabaility[probabaility.length-1]+1);
       int l=0; int r=probabaility.length-1;
       while(l<r){
           int mid=(r-l)/2+l;
           if(x>=probabaility[mid]&&x<probabaility[mid+1]){
               res=mid;
               return res;
           }else if(x<probabaility[mid]){
               r=mid;
           }else{
               l=mid+1;
           }
       }
       return l;
    }

    public static void main(String[] args) {
        Solution(new int[]{3,14,1,7});
        int res = pickIndex();
    }
}
