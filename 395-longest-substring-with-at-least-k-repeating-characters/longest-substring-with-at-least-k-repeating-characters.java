class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        // Try all possible unique character counts
        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {
            int[] count = new int[26];
            int left = 0, right = 0;
            int unique = 0;       // number of unique chars in window
            int countAtLeastK = 0; // number of chars with freq >= k

            while (right < n) {
                // Expand window
                if (count[s.charAt(right) - 'a'] == 0) unique++;
                count[s.charAt(right) - 'a']++;
                if (count[s.charAt(right) - 'a'] == k) countAtLeastK++;
                right++;

                // Shrink window if too many unique chars
                while (unique > uniqueTarget) {
                    if (count[s.charAt(left) - 'a'] == k) countAtLeastK--;
                    count[s.charAt(left) - 'a']--;
                    if (count[s.charAt(left) - 'a'] == 0) unique--;
                    left++;
                }

                // Update answer if all unique chars meet ≥ k
                if (unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        return maxLen;
    }
}
