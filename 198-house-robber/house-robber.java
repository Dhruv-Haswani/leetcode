class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        for(int i = 0 ; i < n ; i++) {
            int temp = r;
            r = Math.max(r,l+nums[i]);
            l = temp;

        }
        return r;
    }
}