class Solution {
    public int destroyTargets(int[] nums, int space) {
        Arrays.sort(nums);
        HashMap<Integer,int[]> dp = new HashMap<>();
        int ans = 1;
        int start = nums[0];
        dp.put(nums[0]%space, new int[] { 1, nums[0] });
        for(int i=1; i<nums.length; i++)
        {
            if(dp.containsKey(nums[i]%space))
            {
                int existingStart = dp.get(nums[i]%space)[1];
                int existingCount = dp.get(nums[i]%space)[0];
                // System.out.println("for "+nums[i]+" existingCount "+existingCount+" existingStart "+existingStart+" ans "+ans);
                if((existingCount+1 > ans) || (existingCount+1 == ans && existingStart < start))
                {
                    // System.out.println("updating start to "+existingStart);
                    ans = existingCount+1;
                    start = existingStart;
                }
                dp.replace(nums[i]%space, new int[] { existingCount+1, existingStart });
            }
            else
            {
                dp.put(nums[i]%space, new int [] { 1, nums[i] });
            }
        }
        return start;
    }
}