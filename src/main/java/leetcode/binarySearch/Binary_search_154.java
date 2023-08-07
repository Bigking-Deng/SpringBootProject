package leetcode.binarySearch;

public class Binary_search_154 {
    //第153题都是不同的值
    public static int findMin_153(int[] nums) {
        int l = 0, r = nums.length-1, pivotIndex=-1;
        while(l<r){
            //若是单增序列最后会是l=r而退出循环
            int mid = (r-l)/2+l;
            if(nums[mid]>nums[mid+1]){
                pivotIndex=mid+1;
                break;
            }else if(nums[mid]>nums[0]){
                l=mid+1;

            }else if(nums[mid]<nums[0]) {
                r = mid;
            }
            //无重复元素
        }
        //若是单增序列返回-1坐标表示不存在
        return pivotIndex;
    }

    //第154题
    public static int findMin_154(int[] nums) {
        int l = 0, r = nums.length-1, pivotIndex=-1;
        //将尾部和头部相同的元素去掉以满足两段性
        while(l<r && nums[r]==nums[l]) r--;
        while(l<r){
            //若是单增序列最后会是l=r而退出循环
            int mid = (r-l)/2+l;
            if(nums[mid]>nums[mid+1]){
                pivotIndex=mid+1;
                break;
            }else if(nums[mid]>=nums[0]){
                l=mid+1;

            }else if(nums[mid]<nums[0]) {
                r = mid;
            }
//            else if(nums[mid]==nums[0]) pivotIndex=-1;
        }
        return pivotIndex;
    }

    //第33题
    public static int search(int[] nums, int target) {
        //还是先找到翻转点
        int l = 0, r = nums.length-1;
        int pivot = -1;
        while(l<r){
            int mid = (r-l)/2+l;
            if(nums[mid]>nums[mid+1]){
                pivot=mid+1;
                break;
            }
            else if(nums[mid]>nums[0]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        //找到pivot翻转点后，确定搜索哪一部分去二分查找
        int ll=0, rr=nums.length-1;
        if (pivot != -1) {
            if(target>=nums[0]){
                rr=pivot-1;
            }else{
                ll=pivot;
            }
        }

        while(ll<=rr){
            int mid2 = (rr-ll)/2+ll;
            if(nums[mid2]==target){
                return mid2;
            }else if(nums[mid2]>target){
                rr=mid2-1;
            }else{
                ll=mid2+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,7,0,1,2};
        int[] nums11 = {1,2,3};
        int[] nums111 = {5,6,7,1,2};
        int res1 = findMin_153(nums1);
        int res11= findMin_153(nums11);
        int res111 = findMin_153(nums111);
        int[] nums2 = {2,3,4,4,5,6,6,7,7,1,1,2,2,2};
        int[] nums22 = {1,1,2,2};
        int res2 = findMin_154(nums2);
        int res22 = findMin_154(nums22);
        int res3 = search(nums1, 6);
        int res33 = search(nums1, 3);
        int res333 = search(new int[]{1}, 0);


    }
}
