class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points.length == k )
        {
            return points;
        }

        int[][] ans = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((b,a) -> Integer.compare(a[0] * a[0] + a[1] * a[1],b[0] * b[0] + b[1] * b[1]));

        for(int[] point : points)
        {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int i = 0;
        while (!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll();
        }
        return ans;
    }
}