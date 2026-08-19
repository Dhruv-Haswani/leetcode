class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[52];
        int ans = 0;
        boolean hasOdd = false;
        
        if (s.length() == 1) {
            return 1;
        }
        
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                freq[c - 'A']++;
            } else {
                freq[c - 'a' + 26]++;
            }
        }
        
        for (int i = 0; i < 52; i++) {
            if (freq[i] % 2 == 0) {
                ans += freq[i];
            } else {
                ans += freq[i] - 1;
                hasOdd = true;
            }
        }
        
        if (hasOdd) ans += 1;  // add center character
        
        return ans;
    }
}
