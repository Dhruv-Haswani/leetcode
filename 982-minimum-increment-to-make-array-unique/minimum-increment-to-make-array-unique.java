class Solution {
    public int minIncrementForUnique(int[] nums) {
        int max = 100000; // constraint limit
        int[] freq = new int[max + nums.length + 1]; 
        // extra space to handle carry beyond max
        
        for (int num : nums) {
            freq[num]++;
        }
        
        int moves = 0;
        int carry = 0;
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] + carry > 1) {
                // keep one at i, push rest forward
                int extra = freq[i] + carry - 1;
                moves += extra;
                carry = extra;
            } else {
                carry = 0; // no surplus
            }
        }
        
        return moves;
    }
}
