class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(res,subset,nums,0);
        return res;
    }

    private void backtrack(List<List<Integer>> res , List<Integer> subset , int[] nums , int index)
    {

        if(index == nums.length)
        {
            if(res.contains(subset)){
                return;
            }
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        backtrack(res,subset,nums,index+1); // take
        subset.remove(subset.size()-1);
        backtrack(res,subset,nums,index+1); // not take

    }
}