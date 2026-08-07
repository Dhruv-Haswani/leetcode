import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> l = new PriorityQueue<>();
        PriorityQueue<Integer> r = new PriorityQueue<>();
        int i = 0;
        int j = costs.length - 1;

        // Fill left heap
        for (int c = 0; c < candidates && i <= j; c++) {
            l.offer(costs[i]);
            i++;
        }

        // Fill right heap
        for (int c = 0; c < candidates && i <= j; c++) {
            r.offer(costs[j]);
            j--;
        }

        long ans = 0;
        while (k-- > 0) {
            if (r.isEmpty() || (!l.isEmpty() && l.peek() <= r.peek())) {
                ans += l.poll();
                if (i <= j) {
                    l.offer(costs[i]);
                    i++;
                }
            } else {
                ans += r.poll();
                if (i <= j) {
                    r.offer(costs[j]);
                    j--;
                }
            }
        }
        return ans;
    }
}
