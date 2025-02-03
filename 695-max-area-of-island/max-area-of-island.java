class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans =0;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==false)
                {
                    ans = Math.max(ans,dfs(grid,vis,i,j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid,boolean[][] vis,int i , int j) 
    {
        if(i<0 || j<0 || i>=grid.length || j >= grid[0].length || grid[i][j]==0 || vis[i][j])
        {
            return 0;
        }
        int max =0;
        vis[i][j] = true;
        max+=dfs(grid,vis,i+1,j);
        max+= dfs(grid,vis,i-1,j);
        max+=dfs(grid,vis,i,j+1);
        max+=dfs(grid,vis,i,j-1);
        return max+1;
    }
}