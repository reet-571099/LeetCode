class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res,n,0,0,"");
        return res;
    }

    private void generate(List<String> res , int max , int open , int close , String cur)
    {
        if(open==max && close == max) {
            res.add(cur);
            return;
        }

        if(open<max)
        {
            generate(res,max,open+1,close,cur+"(");
        }
        if(close<open)
        {
            generate(res,max,open,close+1,cur+")");
        }
    }
}