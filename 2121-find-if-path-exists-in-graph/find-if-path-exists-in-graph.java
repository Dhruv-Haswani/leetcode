class Solution {

    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u); // Undirected graph
        }

        visited = new boolean[n];

        return dfs(source, destination);
    }

    private boolean dfs(int node, int destination) {

        if (node == destination) {
            return true;
        }

        visited[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}