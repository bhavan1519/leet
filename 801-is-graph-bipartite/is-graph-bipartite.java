class Solution {
    public boolean dfs(int node, int c, int[] color, int[][] graph) {
        color[node] = c;
        for (int nbr : graph[node]) {
            if (color[nbr] == -1) {
                if (!dfs(nbr, 1 - c, color, graph)) {
                    return false;
                }
            }
            else if (color[nbr] == c) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
}