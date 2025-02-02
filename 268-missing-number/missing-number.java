class Solution {
    public int missingNumber(int[] nums) {
        int array = 0;
        int full = 0;
        for(int i=0;i<nums.length;i++)
        {
            array^=nums[i];
            full^=i;
        }

        full^=nums.length;

        return array^full;
    }
}