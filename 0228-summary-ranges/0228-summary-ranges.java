class Solution {
    public List<String> summaryRanges(int[] nums) {
        // similar to doing a DFS
        List<String> ans = new ArrayList<>();
        int currentIndex = 0;
        int n = nums.length;
        while(currentIndex < n)
        {
            int it = currentIndex+1;
            while(it < n && nums[it] == nums[it-1]+1)
            {
                it++;
            }
            if(it == currentIndex+1)
            {
                ans.add(String.valueOf(nums[currentIndex]));
            }
            else
            {
                int end = it-1;
                ans.add(nums[currentIndex] + "->" + nums[it-1]);
            }
            currentIndex = it;
        }
        return ans;
    }
}