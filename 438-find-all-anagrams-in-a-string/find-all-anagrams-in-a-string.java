class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length()<p.length()) return res;
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];
        for(char c : p.toCharArray()) {
            pFreq[c-'a']++;
        }
        for(int i = 0 ; i < p.length();i++) {
            windowFreq[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(pFreq,windowFreq)) {
            res.add(0);
        }
        for(int i = p.length(); i < s.length() ; i++) {
            windowFreq[s.charAt(i-p.length())-'a']--;
            windowFreq[s.charAt(i) - 'a']++;
        
        if(Arrays.equals(pFreq,windowFreq)) {
            res.add(i-p.length() + 1);
        }
        }
        return res;


        
    }
}