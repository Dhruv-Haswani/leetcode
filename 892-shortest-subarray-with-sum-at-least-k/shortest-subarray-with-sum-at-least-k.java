class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        for(int j = 0 ; j < n; j++) {
            prefix[j+1] = prefix[j] + nums[j];
        }
        Deque<Integer> d = new ArrayDeque();
        d.addLast(0);
        int ans = Integer.MAX_VALUE;
        for(int j =1 ; j <= n; j++) {
            while(!d.isEmpty() && prefix[j] - prefix[d.peekFirst()] >= k) {
                ans = Math.min(ans,j-d.pollFirst());
            }
            while(!d.isEmpty() && prefix[d.peekLast()] >= prefix[j]) {
                d.pollLast();
            }
            d.addLast(j);

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

        
    }
}