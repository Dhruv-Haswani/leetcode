class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(k==1) {
            return nums;
        }
        int[] ans = new int[n-k+1];
        int index =0;
        Deque<Integer> d = new ArrayDeque();
        for(int i = 0 ; i < n ;i++) {
            while(!d.isEmpty() && d.peekFirst() < i-k+1) {
                d.pollFirst();
            }
            while(!d.isEmpty() && nums[d.peekLast()] <= nums[i]) {
                d.pollLast();
            }
            d.addLast(i);
            if(i>=k-1) {
                ans[index++] = nums[d.peekFirst()];
            }
        }
        return ans;
    }
}