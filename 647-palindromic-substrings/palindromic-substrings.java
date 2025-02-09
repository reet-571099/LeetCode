class Solution {
    public int countSubstrings(String s) {
       if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n]; 
        for(int i = 0 ;i<n;i++)
        {
                dp[i][i] = 1;
        }
        for(int len = 2 ;len<=n;len++)
        {
            for(int i = 0 ;i<=n-len;i++)
            {
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j) && (len==2 || dp[i+1][j-1]==1))
                {
                    dp[i][j] = 1;
                }
            }
        }
        int sum = 0;
        for(int i =0;i<n;i++)
        {
            for(int j =i;j<n;j++)
            {
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}