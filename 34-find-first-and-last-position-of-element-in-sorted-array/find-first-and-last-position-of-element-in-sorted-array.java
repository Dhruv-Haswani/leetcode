class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = -1;
        int l = -1;
        int i = 0;
        int j = nums.length-1;
        while(i <= j) {
            int mid = i + (j-i)/2;
            if(nums[mid] == target) {
                f = mid;
                j = mid-1;
            }  else if(nums[mid]< target) {
                i = mid+1;

            } else {
                j = mid-1;
            }
        }
        i = 0;
        j = nums.length-1;
        while(i <= j) {
            int mid = i + (j-i)/2;
            if(nums[mid]==target){
                l = mid;
                i = mid+1;

            } else if(nums[mid]< target){
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return new int[]{f,l};
        
    }
}