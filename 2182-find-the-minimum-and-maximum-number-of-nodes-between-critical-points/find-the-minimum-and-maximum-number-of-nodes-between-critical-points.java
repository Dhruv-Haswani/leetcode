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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Result array: [minDistance, maxDistance]
        int[] result = new int[]{-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return result; // fewer than 3 nodes → no critical points
        }

        int index = 1; // start from second node
        ListNode prev = head;
        ListNode curr = head.next;

        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {
            int nextVal = curr.next.val;

            // Check if current node is a local maxima or minima
            if ((curr.val > prev.val && curr.val > nextVal) ||
                (curr.val < prev.val && curr.val < nextVal)) {

                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    minDistance = Math.min(minDistance, index - lastCritical);
                    result[1] = index - firstCritical; // max distance
                }
                lastCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (minDistance != Integer.MAX_VALUE) {
            result[0] = minDistance;
        }

        return result;
    }
}
