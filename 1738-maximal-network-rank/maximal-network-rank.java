class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for (int[] edge : roads) {
            int u = edge[0], v = edge[1];
            map.putIfAbsent(u,new ArrayList<>());
            map.get(u).add(v);

            map.putIfAbsent(v,new ArrayList<>());
            map.get(v).add(u);
        }
        int max = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
               int m = map.getOrDefault(i, Collections.emptyList()).size();
               int t = map.getOrDefault(j, Collections.emptyList()).size();
                int ans = m+t;
                if (map.getOrDefault(i, Collections.emptyList()).contains(j)) {
                    ans=ans-1;
                }
                max = Math.max(max,ans);
            }
        }
        return max;
    }
}