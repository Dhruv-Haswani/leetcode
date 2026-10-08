class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> d = new ArrayDeque();
        dp[0] = nums[0];
        d.addLast(0);
        int ans = dp[0];
        
        for(int i = 1 ; i < n ; i++) {
            while(!d.isEmpty() && d.peekFirst() < i-k) {
                d.pollFirst();
            }
            dp[i] = nums[i] + Math.max(0,dp[d.peekFirst()]);
            while(!d.isEmpty() && dp[d.peekLast()] <= dp[i]) {
                d.pollLast();
            }
            d.addLast(i);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
        
    }
}