class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> s1 = new Stack<>();
        int adds = 0;
        for (char c : s.toCharArray()) {
            if(c == '('){
                s1.push(c);
            }else {
                if(!s1.isEmpty()) {
                    s1.pop();
                } else {
                    adds++;
                }
            }
        }
        return adds + s1.size();
    
        
    }
}