class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder r = new StringBuilder();
        for(int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek()==c) {
                stack.pop();
            }else{
                stack.push(c);
            }
        }
            while(!stack.isEmpty()) {
                r.append(stack.pop());
            }
            return r.reverse().toString();
        
    }
}