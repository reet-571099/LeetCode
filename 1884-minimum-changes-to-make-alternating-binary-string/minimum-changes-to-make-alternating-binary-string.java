class Solution {
    public int minOperations(String s) {
        int count_zero = 0;
        int count_one = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if(i%2==0)
            {
                if(s.charAt(i)=='0')
                {
                    count_one++;
                }
                else
                {
                    count_zero++;
                }
            }
            else {
                if(s.charAt(i)=='0')
                {
                    count_zero++;
                }
                else
                {
                    count_one++;
                }
            }
        }

        return Math.min(count_one,count_zero);
    }
}