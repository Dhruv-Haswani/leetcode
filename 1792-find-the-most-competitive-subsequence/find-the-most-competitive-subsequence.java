class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] s = new int[k];
        int top = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            // Pop larger elements if we can still fill subsequence
            while (top > 0 && s[top - 1] > num && (top - 1 + (n - i) >= k)) {
                top--;
            }

            // Push current element if we still need more
            if (top < k) {
                s[top++] = num;
            }
        }

        return s;
    }
}
