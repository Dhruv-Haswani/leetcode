class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> d = new ArrayDeque(); 
        dp[0] = nums[0];
        d.addLast(0);
        for(int i = 1; i < n; i++) {
            while(!d.isEmpty() && d.peekFirst() < i-k) {
                d.pollFirst();
            }
            dp[i] = nums[i] + dp[d.peekFirst()];
            while(!d.isEmpty() && dp[d.peekLast()] <= dp[i]) {
                d.pollLast();
            }
            d.addLast(i);
        }
        return dp[n-1];


        
    }
}