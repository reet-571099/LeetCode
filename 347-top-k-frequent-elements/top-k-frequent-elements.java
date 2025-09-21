class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res= new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a,b)->Integer.compare(a.getValue(),b.getValue()));
        for (Map.Entry<Integer, Integer> freq : map.entrySet()) {
            heap.offer(freq);
            if(heap.size()>k)
            {
                heap.poll();
            }
        }

        for(int j =0;j<k;j++)
        {
            res[j] = heap.poll().getKey();
        }
         return res;
    }
}