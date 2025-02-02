class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0]=1;

        for(int i =1;i<=n;i++)
        {
             for(int j=0;j<i;j++) {
                String check = s.substring(j,i);
                if(dp[j] > 0 &&  wordDict.contains(check))
                {
                    dp[i] = dp[i]+ dp[j];
                }
             }
        }
        return dp[n]>0;
    }
}