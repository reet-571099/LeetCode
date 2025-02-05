class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int dp[] = new int [s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) =='0')
        {
            dp[1] = 0;
        }
        else {
            dp[1] = 1;
        }
        for(int i=2;i<=s.length();i++)
        {
            if(s.charAt(i-1) > '0' && s.charAt(i-1) <= '9')
            {
                dp[i] = dp[i-1];
            }
            if(Integer.valueOf(s.substring(i-2,i)) >= 10 && Integer.valueOf(s.substring(i-2,i)) <= 26)
            {
                dp[i] +=dp[i-2];
            }
           
        }
        return dp[s.length()];
    }
}