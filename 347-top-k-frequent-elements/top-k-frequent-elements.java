class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>>maxHeap = new PriorityQueue<>((a,b)->Integer.compare(a.getValue(),b.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            maxHeap.offer(entry);
            if(maxHeap.size()>k)
            {
                maxHeap.poll();
            }
        }
        int arr[] = new int[k];
        for(int i=0;i<k;i++){
            arr[i] = maxHeap.poll().getKey();
        }
        return arr;
    }
}