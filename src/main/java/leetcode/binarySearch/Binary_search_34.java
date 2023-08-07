package leetcode.binarySearch;

public class Binary_search_34 {
    public static int[] findBound(int []nums, int target){
        int lleft = 0, lright = nums.length - 1;
        int lb = -1;
        while(lleft <= lright){
            int lmid = lleft + (lright - lleft)/2;
            if(nums[lmid]==target){
                if((lmid -1 )>=0 && nums[lmid]>nums[lmid -1]){
                    lb = lmid;
                    break;
                }else if((lmid -1 )>=0 && nums[lmid]==nums[lmid -1]){
                    lright = lmid-1;
                }else if(lmid==0){
                    lb = 0;
                    break;
                }
            }
            else if(nums[lmid]<target){
                lleft = lmid+1;
            }else if(nums[lmid]>target){
                lright = lmid-1;
            }
        }

        int rleft = 0, rright = nums.length - 1;
        int rb = -1;
        while(rleft <= rright){
            int rmid = rleft + (rright - rleft)/2;
            if(nums[rmid]==target){
                if((rmid +1 )<=nums.length-1 && nums[rmid]<nums[rmid +1]){
                    rb = rmid;
                    break;
                }else if((rmid +1 )<=nums.length-1 && nums[rmid]==nums[rmid +1]){
                    rleft = rmid+1;
                }else if(rmid==nums.length-1){
                    rb = nums.length-1;
                    break;
                }
            }
            else if(nums[rmid]<target){
                rleft = rmid+1;
            }else if(nums[rmid]>target){
                rright = rmid-1;
            }
        }

        return new int[]{lb, rb};
    }

    public static void main(String[] args) {
        int arr[] = {5,7,7,8,8,10};
        int tar = 8;
        int res[] = Binary_search_34.findBound(arr, tar);
        System.out.println(res[0]+" "+res[1]);
    }
}
