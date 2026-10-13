import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // Edge case: single node
        if (n == 1) {
            return Arrays.asList(0);
        }

        // Adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Degree (indegree in this context)
        int[] degree = new int[n];

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        // Queue for leaf nodes
        Queue<Integer> queue = new LinkedList<>();

        // Push all initial leaf nodes
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int nodes = n;

        // Trim leaves level by level
        while (nodes > 2) {
            int size = queue.size();
            nodes -= size;

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int neighbor : adj.get(curr)) {
                    degree[neighbor]--;

                    // If it becomes a leaf
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Remaining nodes are roots of MHTs
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }

        return ans;
    }
}