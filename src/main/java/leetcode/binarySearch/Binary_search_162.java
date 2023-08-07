package leetcode.binarySearch;

public class Binary_search_162 {
    public static int findPeakElement(int[] nums){
        if(nums.length==1) return 0;
        int l=0, r=nums.length-1;
        while(l<r){
            int mid = (r-l)/2+l;
            //mid已经为0的情况必然只剩nums[0]和nums[1]两个元素来处理越界问题
            if(mid==0){
                return nums[mid]>nums[mid+1]?0:1;
            }
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid]>nums[mid-1]&&nums[mid]<nums[mid+1]){
                l=mid+1;
            }
//            else if(nums[mid]<=nums[mid-1]&&nums[mid]>=nums[mid+1]){
//                r=mid-1;
//            }
            else{
                r=mid-1;
                }
        }
        return l;
    }

    public static int findPeakElement2(int[] nums){
        int l = 0, r = nums.length - 1;
        //由于只有两个元素的情况下mid必靠左，不会出现mid+1越界，mid=(l+r)/2且l<r情况放心用mid+1
        //当mid=（(l+r)/2）+1 mid必靠右，不会出现mid-1越界
        while (l < r) {
            int mid = (r-l)/2+l;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public static void main(String[] args) {
        int res = findPeakElement(new int[]{3,4,5});
    }
}
