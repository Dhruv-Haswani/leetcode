class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] starts = new int[n][2];
        for(int i = 0; i < n ; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1]= i ;

        }
        Arrays.sort(starts,(a,b)->Integer.compare(a[0],b[0]));
        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++) {
            int target = intervals[i][1];
            int l =0;
            int r = n-1;
            int res = -1;
            while(l<=r) {
                int mid = l + (r-l)/2;
                if(starts[mid][0] >= target){
                    res = starts[mid][1];
                    r = mid-1;
                } else {
                    l = mid+1;

                }
            }
            ans[i] = res;
        }
        return ans;
        
    }
}