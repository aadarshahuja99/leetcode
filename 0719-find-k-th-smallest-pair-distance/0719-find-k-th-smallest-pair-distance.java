class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0];
        int max = nums[n-1];
        int s = 0;
        int e = max - min;
        int ans = 0;
        while(s <= e)
        {
            int m = s + (e - s)/2;
            // check function of binary search
            int countValidPairs = 0;
            for(int i=0, j=1; i<n-1; i++)
            {
                // intuition: for each i, find the number of pairs that satisfy the condition, this works in linear time as j loop is only done once acorss the array
                if(j == i)
                {
                    j = i+1;
                }
                while(j < n && nums[j] - nums[i] <= m)
                {
                    j++;
                }
                countValidPairs += (j - i - 1);
            }
            if(countValidPairs >= k)
            {
                ans = m;
                e = m-1;
            }
            else
            {
                s = m+1;
            }
        }
        return ans;
    }
}