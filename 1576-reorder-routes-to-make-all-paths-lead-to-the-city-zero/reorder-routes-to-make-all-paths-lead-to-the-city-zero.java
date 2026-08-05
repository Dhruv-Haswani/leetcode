class Solution {
      int count = 0;
    public int minReorder(int n, int[][] connections) {
        
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0;i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : connections) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(new int[]{b,1});
            graph[b].add(new int[]{a,0});
        }
        boolean[] visited = new boolean[n];
        dfs(0,graph,visited);
        return count;
        
    }
    private void dfs(int city,List<int[]>[] graph,boolean[]visited) {
        visited[city] = true;
        for(int[] neighbour : graph[city]) {
            int nextCity = neighbour[0];
            int needReverse = neighbour[1];
            if(!visited[nextCity]) {
                count += needReverse;
                dfs(nextCity,graph,visited);
            }
        }
    }
}