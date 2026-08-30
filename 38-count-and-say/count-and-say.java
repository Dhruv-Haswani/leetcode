class Solution {
    public String countAndSay(int n) {
        String current = "1";
        for(int j = 2;j<=n;j++) {
            StringBuilder n1 = new StringBuilder();
            int i = 0;
            while(i<current.length()) {
                char currentChar = current.charAt(i);
                int count = 1;
                while(i+1<current.length() && current.charAt(i+1)==currentChar){
                    count++;
                    i++;

                }
                n1.append(count).append(currentChar);
                i++;
                
            }
            current = n1.toString();
        }
        return current;
        
    }
}