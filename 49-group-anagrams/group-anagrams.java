class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0 || strs.length == 1){
            res.add(Arrays.asList(strs[0]));
            return res;
        }
        Map<String , List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String key = new String(charArray);
            // If the key is not in the map, create a new list for it
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            // Add the original string to the corresponding anagram group
            map.get(key).add(str);
        }

        for (List<String> group : map.values()) {
            res.add(group);
        }

        return res;
    }
}