class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int ans = 0;
        long sum = 0;
        int i = 0;
        Deque<Integer> d = new ArrayDeque<>();
        
        for (int j = 0; j < n; j++) {
            // Maintain deque for maximum chargeTime
            while (!d.isEmpty() && chargeTimes[d.peekLast()] <= chargeTimes[j]) {
                d.pollLast();
            }
            d.addLast(j);
            
            sum += runningCosts[j];
            
            // Shrink window if cost exceeds budget
            while (!d.isEmpty() && (long)(j - i + 1) * sum + chargeTimes[d.peekFirst()] > budget) {
                sum -= runningCosts[i];
                if (d.peekFirst() == i) {
                    d.pollFirst();
                }
                i++;
            }
            
            ans = Math.max(ans, j - i + 1);
        }
        
        return ans;
    }
}
