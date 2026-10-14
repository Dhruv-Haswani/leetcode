class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i =0;
        long count = 0;
        int n = nums.length;
        for(int j = 0; j< n; j++) {
            while(!maxd.isEmpty() && nums[maxd.peekLast()] < nums[j]) {
                maxd.pollLast();
            }
            maxd.offerLast(j);
            while(!mind.isEmpty()&&nums[mind.peekLast()]> nums[j]){
                mind.pollLast();
            }
            mind.offerLast(j);
            while(!maxd.isEmpty() && !mind.isEmpty()&& nums[maxd.peekFirst()]-nums[mind.peekFirst()] > 2){
                if(maxd.peekFirst()<mind.peekFirst()) {
                    i = maxd.peekFirst() +1;
                    maxd.pollFirst();
                } else {
                    i = mind.peekFirst() + 1;
                    mind.pollFirst();
                }
            }
            count += j-i+1;

        }
        return count;
    }
}