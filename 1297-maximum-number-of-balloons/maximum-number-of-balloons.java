class Solution {
    public int maxNumberOfBalloons(String text) {
        int [] count = new int[26];
        for(int i=0;i<text.length();i++)
        {
            count[text.charAt(i)-'a']++;
        }
        int res = count[1]; //b
        res = Math.min(res , count[0]); //a
        res = Math.min(res , count[11]/2); //l
        res = Math.min(res , count[14]/2); //o
        res = Math.min(res , count[13]); //n

        return res;
    }
}