class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) return 0;
        int max = nums[0];
        int curr_max=nums[0];
        int curr_min = nums[0];

        for(int i = 1;i<n;i++){
            int num = nums[i];
            if(num<0){
                int temp = curr_max;
                curr_max = curr_min;
                curr_min = temp;
            }
            curr_max = Math.max(num,curr_max*num);
            curr_min = Math.min(num,curr_min*num);
            max = Math.max(max,curr_max);
        }
        return max;
        
    }
}