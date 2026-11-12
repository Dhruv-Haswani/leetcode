class Solution {

    private boolean dfs(int node, List<List<Integer>> graph, int[] state) {

        if (state[node] == 1) {
            return true; // cycle detected
        }

        if (state[node] == 2) {
            return false; // already processed
        }

        state[node] = 1; // visiting

        for (int neighbor : graph.get(node)) {
            if (dfs(neighbor, graph, state)) {
                return true;
            }
        }

        state[node] = 2; // fully processed
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(i, graph, state)) {
                    return false;
                }
            }
        }

        return true;
    }
}