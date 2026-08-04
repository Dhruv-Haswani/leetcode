class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit, n);
            }
        }
        return numberOfComponents;
    }

    private void dfs(int node, int[][] isConnected, boolean[] visit, int n) {
        visit[node] = true;
        for (int i = 0; i < n; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit, n);
            }
        }
    }
}
