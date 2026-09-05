class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }

        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            if (s.contains(curr.val) && 
                (curr.next == null || !s.contains(curr.next.val))) {
                count++;
            }
            curr = curr.next;
        }

        return count;
    }
}
