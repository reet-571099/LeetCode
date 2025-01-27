class Solution {
    public int largestPerimeter(int[] nums) {
      Arrays.sort(nums);
      for(int i = nums.length-1 ;i>1;i--)
      {
        boolean isTriangle = checkisTriangle(nums[i],nums[i-1],nums[i-2]);
        if(isTriangle)
        {
            return (nums[i]+nums[i-1]+nums[i-2]);
        }
        else {
            continue;
        }
      }
      return 0;  
    }

    private boolean checkisTriangle(int i , int j, int k)
    {
            if(i+j<=k || i+k<=j || j+k <=i)
            {
                return false;
            }
            return true;
            
    }
}