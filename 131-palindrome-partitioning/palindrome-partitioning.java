class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(0,s,temp,res);
        return res;
    }

    private void backtrack(int index , String s , List<String> temp , List<List<String>> res){
        if(index == s.length())
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index ; i <s.length();i++)
        {
            if(isPalindrome(s,index,i))
            {
                temp.add(s.substring(index,i+1));
                backtrack(i+1,s,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int start,int end)
    {
       while(start<=end)
       {
        if(s.charAt(start++)!=s.charAt(end--))
        {
            return false;
        }
       }
       return true;
    }
}