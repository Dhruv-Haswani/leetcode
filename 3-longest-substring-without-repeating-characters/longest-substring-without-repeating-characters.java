class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character,Integer> m = new HashMap<>();
        int l = 0;
        int max_len = 0;
        if(s.length() == 1) {
            return 1;
        }
        for(int r = 0 ; r < s.length() ; r++) {
            char c = s.charAt(r);
            if(m.containsKey(c) && m.get(c) >= l) {
                l = m.get(c) + 1;
            }
            m.put(c,r);
            max_len = Math.max(max_len,r-l+1);
        }
        return max_len;
    }
 
}