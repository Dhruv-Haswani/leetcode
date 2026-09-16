class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (!s.isEmpty() && k > 0 && s.peek() > digit) {
                s.pop();
                k--;
            }
            s.push(digit);
        }
        
        // Remove remaining digits if k > 0
        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }
        
        // Build result
        StringBuilder ans = new StringBuilder();
        while (!s.isEmpty()) {
            ans.append(s.pop());
        }
        ans.reverse();
        
        // Remove leading zeros
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        
        if (i == ans.length()) return "0";
        return ans.substring(i);
    }
}
