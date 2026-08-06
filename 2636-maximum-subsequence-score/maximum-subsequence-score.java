class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int [][]pair = new int[n][2];
        for(int i = 0 ; i < n ; i++) {
            pair[i][0] = nums2[i];
            pair[i][1] = nums1[i];
        }
        Arrays.sort(pair,(a,b)->b[0]-a[0]);
        PriorityQueue<Integer>q = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        for(int[]p:pair) {
            sum += p[1];
            q.offer(p[1]);
            if(q.size()>k) {
                sum -= q.poll();
            }
            if(q.size()==k){
                ans = Math.max(ans,sum*p[0]);
            }

        }
        return ans;
        
    }
}