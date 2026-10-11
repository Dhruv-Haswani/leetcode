class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int maxGain = 0;
        int gain = 0;
        int satisfied = 0;
        for(int i = 0; i < n ; i++) {
            if(grumpy[i] == 0) {
                satisfied += customers[i];

            } else {
                gain += customers[i];
            }
            if(i >= minutes) {
                if(grumpy[i-minutes]==1) {
                    gain -= customers[i-minutes];
                }
            }
            maxGain = Math.max(maxGain,gain);
            

        }
        return maxGain + satisfied;
        
    }
}