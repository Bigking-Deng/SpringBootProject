package leetcode;

public class binary_search_34 {
    public static int[] findBound(int []array, int target){
        int lleft = 0, lright = array.length - 1;
        int lmid = lleft + (lright - lleft)/2, lb = -1;
        while(lleft <= lright){
            lmid = lleft + (lright - lleft)/2;
            if((lmid -1 )>=0 && array[lmid]>array[lmid -1] && array[lmid]==target){
                lb = lmid;
                break;
            }else if(lmid == 0 && array[lmid]==target){
                lb = 0;
                break;
            }
            else if(array[lmid]<target){
                lleft = lmid+1;
            }else if(array[lmid]>=target){
                lright = lmid-1;
            }
        }

        int rleft = 0, rright = array.length - 1;
        int rmid = rleft + (rright - rleft)/2, rb = -1;
        while(rleft <= rright){
            rmid = rleft + (rright - rleft)/2;
            if((rmid + 1 )<=array.length && array[rmid]<array[rmid + 1] && array[rmid]==target){
                rb = rmid;
                break;
            }else if(rmid == array.length -1 && array[rmid]==target){
                rb = array.length -1;
                break;
            }
            else if(array[rmid]<=target){
                rleft = rmid+1;
            }else if(array[rmid]>target){
                rright = rmid-1;
            }
        }

        return new int[]{lb, rb};
    }

    public static void main(String[] args) {
        int arr[] = { 1,2,2,3,4,5,6,6};
        int tar = 6;
        int res[] = binary_search_34.findBound(arr, tar);
        System.out.print(res[0]+" "+res[1]);
    }
}
