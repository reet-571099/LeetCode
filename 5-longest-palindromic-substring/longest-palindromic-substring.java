class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (s == null || s.length() == 0) return "";
        String ans = "";
        ans = s.substring(0,1);
        boolean [][] dp = new boolean[n][n];
        for(int i = 0;i<s.length();i++)
        {
            dp[i][i] = true;
        }
        for(int len = 2;len<=n;len++)
        {
            for(int i=0;i<=n-len;i++)
            {
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && (len==2 || dp[i+1][j-1]))
                {
                    dp[i][j] = true;
                    if(len>ans.length())
                    {
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
}