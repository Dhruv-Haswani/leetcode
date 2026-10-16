import java.util.*;

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        // Only three candidates matter: positions n/4, n/2, 3n/4
        int[] candidates = {arr[n / 4], arr[n / 2], arr[(3 * n) / 4]};
        
        for (int x : candidates) {
            int left = lowerBound(arr, x);
            int right = upperBound(arr, x);
            if (right - left > n / 4) {
                return x;
            }
        }
        return -1; // should never happen due to problem guarantee
    }
    
    // Binary search for leftmost occurrence
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    
    // Binary search for rightmost occurrence
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
