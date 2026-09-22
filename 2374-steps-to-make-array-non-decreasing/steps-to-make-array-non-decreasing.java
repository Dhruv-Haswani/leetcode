class Solution {
    public int totalSteps(int[] nums) {
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        int dp[] = new int[nums.length];

       for (int i=0; i<nums.length; i++){
        int count = 0;

        while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]){
            count = Math.max(count, dp[stk.pop()]);
        }

        if (!stk.isEmpty()){
            dp[i] = count + 1;
        }

        ans = Math.max(ans, dp[i]);
        stk.push(i);
       }
        return ans;
    }
}