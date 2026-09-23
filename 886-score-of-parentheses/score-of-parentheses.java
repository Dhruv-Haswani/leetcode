class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(0);
        for(char c : s.toCharArray()) {
            if(c == '('){
                s1.push(0);
            } else {
                int x = s1.pop();
                int y = s1.pop();
                s1.push(y+Math.max(2*x,1));
            }
        }
        return s1.pop();
    }
}
   