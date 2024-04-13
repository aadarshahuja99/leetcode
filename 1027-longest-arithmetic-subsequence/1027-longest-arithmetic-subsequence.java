class Solution {
    public int longestArithSeqLength(int[] nums) {
        // more optimal solution than the previous one
        int n = nums.length;
        if(n == 2)
        {
            return 2;
        }
        HashMap<Integer,Integer>[] dp = new HashMap[n];
        for(int i=0; i<n; i++)
        {
            dp[i] = new HashMap<>();
        }

        dp[1].put(nums[1]-nums[0], 2);

        int longest = 2;

        for(int i=2; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                int diff = nums[i] - nums[j];
                int currentLength = 2;
                if(dp[j].containsKey(diff))
                {
                    currentLength = dp[j].get(diff) + 1;
                }
                longest =  Math.max(currentLength, longest);
                if(currentLength > dp[i].getOrDefault(diff,0))
                {
                    dp[i].put(diff, currentLength);
                }
            }
        }
        return longest;

        // // intuition: find out all possible differences between pairs of array elements. This will take o(n^2) time. For each difference, find out the previous elements (elements that occur before the smaller index of the pair) that maintain the AP property (i.e the difference between the initially chosen elements).
        // if(nums.length <= 2)
        // {
        //     return nums.length;
        // }
        // int ans = 2;
        // // memoization is not traditional for this one. Because, we are indexing on diff, which can be huge and storing all possible values of diff in a 2d matrix is not optimal. Instead, use a map.
        // HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        // for(int i=0; i<nums.length; i++)
        // {
        //     map.put(i,new HashMap<Integer,Integer>());
        // }
        // for(int i=0; i<nums.length; i++)
        // {
        //     for(int j=i+1; j<nums.length; j++)
        //     {
        //         int currentDiff = nums[j]-nums[i];
        //         ans = Math.max(ans, 2+count(i,currentDiff,nums,map));
        //     }
        // }
        // return ans;
    }
}