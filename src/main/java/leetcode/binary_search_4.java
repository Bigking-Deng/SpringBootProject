package leetcode;

public class binary_search_4 {
    public static Integer medianSort(int []A, int []B){
        int half, midA, midB, medianA=0, medianB=0;
        boolean isOdd;
        if((A.length + B.length)%2 == 0){
            half = (A.length + B.length)/2;
            isOdd = false;
        }else {
            half = (A.length + B.length +1)/2;
            isOdd = true;
        }
        int left = 0, right = A.length-1;
        while (left < right){
            midA = left + (right - left)/2;
            midB = half - (midA + 1) - 1;
            if(A[midA] > B[midB+1] && B[midB] < A[midA + 1]){
                right = midA ;
            }else if(B[midB] > A[midA + 1] && A[midA] < B[midB + 1]){
                left = midA + 1;
            }else{
                medianA = midA;
                medianB = midB;
            }
        }
       if(left == right){
           medianA = left;
           medianB = half - (medianA + 1) - 1;
       }
       if(isOdd){
           return Math.max(A[medianA], B[medianB]);
       }else {
           return (Math.max(A[medianA], B[medianB])+Math.min(A[medianA+1], B[medianB+1]))/2;
       }
    }
}
