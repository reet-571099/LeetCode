class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points.length == k )
        {
            return points;
        }

        int[][] ans = new int[k][2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> Math.sqrt(a[0] * a[0] + a[1] * a[1])));

        for(int[] point : points)
        {
            minHeap.offer(point);
        }

        for (int i = 0; i < k; ++i) {
            int[] point = minHeap.poll();
            ans[i] = new int[]{point[0], point[1]};
        }
        return ans;
    }
}