class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunks= 0;
        for(int i = 0 ; i <arr.length;i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(max == i) {
                chunks++;

            }
        }
        return chunks;
        
    }
}