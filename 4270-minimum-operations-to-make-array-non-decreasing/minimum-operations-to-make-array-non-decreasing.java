class Solution {
    public long minOperations(int[] nums) {
        long ans = 0;
        long carry = 0;
        for(int i = 1 ; i < nums.length;i++){
            long prev = nums[i-1]+carry;
            long curr = nums[i]+carry;
            if(prev>curr){
                long deficit = prev-curr;
                ans +=deficit;
                carry += deficit;
            }
        }
    return ans;    
    }
}