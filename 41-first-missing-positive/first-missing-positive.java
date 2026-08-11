class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0 ; i <n;i++){
            while(nums[i] >= 1 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                int corrIndex = nums[i]-1;
                int temp = nums[i];
                nums[i] = nums[corrIndex];
                nums[corrIndex] = temp;
                 
            }
        }
        for(int i = 0 ; i<n ; i++) {
            if(nums[i] != i+1){
            return i+1;
        }
    }
    return n+1;
}
}