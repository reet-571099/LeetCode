class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word:words)
        {
            map.put(word,map.getOrDefault(word,0)+1);
        }

    PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.getValue() != a.getValue()) {
                return Integer.compare(b.getValue(), a.getValue()); // Descending order of frequency
            }
            return a.getKey().compareTo(b.getKey()); // Lexicographical order of string
        });

        maxHeap.addAll(map.entrySet());

        List<String> res = new ArrayList<>();
        for(int i =0;i<k;i++)
        {
            res.add(maxHeap.poll().getKey());
        }
    return res;
    }
}