class Solution {
    private int result = 0;
    public int maxLength(List<String> arr) {
        
        if(arr.size()==0)
        {
            return 0;
        }
        solve(arr,0,"");
        return result;
    }

    private void solve(List<String> arr , int index , String s )
    {
        boolean isUnique = isUniqueCheck(s);
        
        if(isUnique){
            result = Math.max(s.length(),result);
        }

        if(index == arr.size() || !isUnique) return ;

        for(int i = index;i<arr.size();i++)
        {
            solve(arr,i+1,s+arr.get(i));
        }
   
    }

    private boolean isUniqueCheck(String s)
    {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
        if (set.contains(c)) {
            return false;
        }
        set.add(c);
        }
        return true;
    }
}