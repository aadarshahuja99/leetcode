class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // without extra space
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            int num = Math.abs(nums[i]);
            if(nums[num-1] < 0)
            {
                list.add(num);
            }
            else
            {
                nums[num-1] = -1*nums[num-1];
            }
        }
        return list;
    }
}