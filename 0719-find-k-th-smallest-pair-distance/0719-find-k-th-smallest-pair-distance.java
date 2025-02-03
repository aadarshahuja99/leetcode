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
            int count = 0;
            for(int i=0, j=1; i<n-1; i++)
            {
                if(j == i)
                {
                    j = i+1;
                }
                while(j < n && nums[j] - nums[i] <= m)
                {
                    j++;
                }
                count += (j - i - 1);
            }
            // System.out.println(count+" for "+m);
            if(count >= k)
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