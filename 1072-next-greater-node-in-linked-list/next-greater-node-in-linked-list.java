/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            vals.add(curr.val);
            curr =  curr.next;

        }
        int[] ans = new int[vals.size()];
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<vals.size();i++) {
            while(!s.isEmpty() && vals.get(i)>vals.get(s.peek())) {
                int index = s.pop();
                ans[index] = vals.get(i);
            }
            s.push(i);
        }
        return ans;
    }
}