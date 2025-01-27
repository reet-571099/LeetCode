class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int[n][m];
        for(int[] arr : dp)
        {
            Arrays.fill(arr,-1);
        }
        return memoization(n-1,m-1,grid,dp);
    }

    private int memoization(int i , int j , int[][] grid , int[][] dp)
    {
        if(i==0 && j ==0) return grid[0][0];
        if(i<0 || j<0) return (int)(1e9);
        if(dp[i][j]!=-1) return dp[i][j];

        int left = grid[i][j] + memoization(i,j-1,grid,dp);
        int top = grid[i][j] + memoization(i-1,j,grid,dp);

        return dp[i][j] = Math.min(left,top);
       
    }
}