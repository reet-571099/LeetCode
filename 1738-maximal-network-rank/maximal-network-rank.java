import java.util.*;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n]; // Store degree (number of roads) of each city
        Set<String> edges = new HashSet<>(); // Store direct connections
        
        // Step 1: Count degrees & store edges
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            degree[u]++;
            degree[v]++;
            edges.add(u + "," + v); // Store connection as string
            edges.add(v + "," + u); // Bidirectional
        }

        int maxRank = 0;

        // Step 2: Compare only meaningful pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j];

                // If directly connected, subtract 1
                if (edges.contains(i + "," + j)) {
                    rank--;
                }

                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}
