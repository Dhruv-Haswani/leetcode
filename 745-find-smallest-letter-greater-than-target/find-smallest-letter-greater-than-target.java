class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0, j = letters.length - 1;
        
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (letters[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        
        // If i goes out of bounds, wrap around to first letter
        return letters[i % letters.length];
    }
}
