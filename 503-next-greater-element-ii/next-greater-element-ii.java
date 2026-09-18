class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < 2*n-1 ; i++) {
            int num = nums[i % n];
            while(!s.isEmpty() &&nums[s.peek()] < num) {
                ans[s.pop()] = num;
            }
            if(i < n) s.push(i);
        }
        
    
    return ans;
}
}