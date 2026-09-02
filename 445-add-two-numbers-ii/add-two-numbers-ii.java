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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null) {
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2=l2.next;
        }
        ListNode head = null;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int sum = a + b + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(digit);
            node.next = head;
            head = node;
        }
        if(carry >0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head;

        
    }
}