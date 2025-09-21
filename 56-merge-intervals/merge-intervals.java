class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] newinterval = intervals[0];
        List<int[]>res = new ArrayList<>();
        res.add(newinterval);
        for(int[] interval : intervals)
        {
            if(interval[0]<=newinterval[1])
            {
                newinterval[1] = Math.max(newinterval[1],interval[1]);
            }
            else{
                newinterval = interval;
                res.add(interval);
            }
        }
        return res.toArray(new int [res.size()][2]);
    }
}