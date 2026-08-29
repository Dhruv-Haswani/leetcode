class Solution {
    public String longestNiceSubstring(String s) {
        
        if(s.length() == 1) {
            return "";
        }
        HashSet<Character> s1 = new HashSet<>();
        for(char c : s.toCharArray()) {
            s1.add(c);
        }
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(!s1.contains(Character.toLowerCase(c)) || !s1.contains(Character.toUpperCase(c))) {
                String l = longestNiceSubstring(s.substring(0,i));
                String r = longestNiceSubstring(s.substring(i+1));
                return l.length() >= r.length() ? l : r;


            }
        }
        return s;
    }
}