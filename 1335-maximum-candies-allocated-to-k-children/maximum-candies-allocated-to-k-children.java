class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int l =1 ;
        int r = 0;
        for(int c : candies) {
            r = Math.max(r,c);
        }
        int ans = 0;
        while(l <= r) {
            int mid = l + (r-l)/2;
            long children = 0;
            for(int c : candies) {
                children += c / mid;
            }
            if(children >= k) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}