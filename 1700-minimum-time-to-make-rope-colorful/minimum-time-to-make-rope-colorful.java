class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total = 0;
        int left =0; 
        for(int i =1;i<colors.length();i++)
        {
            if(colors.charAt(i)==colors.charAt(i-1))
            {
                int cur = Math.min(neededTime[i],neededTime[i-1]);
                total+=cur;
                if(neededTime[i-1]>neededTime[i])
                {
                    neededTime[i] = neededTime[i-1];
                }
            }
        }
        return total;
    }
}