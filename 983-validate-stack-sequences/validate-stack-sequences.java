class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        if(pushed.length != popped.length) {
            return false;
        }
        for(int x : pushed) {
            s.push(x);
            while(!s.isEmpty() && j < popped.length && s.peek() == popped[j]) {
                s.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}