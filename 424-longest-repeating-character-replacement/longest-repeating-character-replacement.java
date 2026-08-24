class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0;
        int maxFreq = 0;
        int ans = 0;
        for(int j = 0 ; j < s.length() ; j++){
            int idx = s.charAt(j)-'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq,freq[idx]);
            int window = j - i + 1;
            int replacements = window - maxFreq;
            while(replacements > k) {
                freq[s.charAt(i)-'A']--;
                i++;
                window = j - i + 1;
                replacements = window - maxFreq;
            }
            ans = Math.max(ans,window);
        }
        return ans;
    }
}