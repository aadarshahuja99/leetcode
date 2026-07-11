class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2)
            {
                if(e1[0] != e2[0])
                {
                    return e1[0] - e2[0];
                }
                return e2[1] - e1[1]; // order the envs with the same length in descreasing order of their widths.
            }
        });
        int[] nums = new int[envelopes.length];
        nums[0] = envelopes[0][1];
        int ans = 1;
        for(int i=1; i<envelopes.length; i++)
        {
            // reasoning: if width of current element is greater than the LIS last element, then its length must definitely be greater than the last element in LIS as envelopes with same length have decreasing width order and the list is sorted on the basis of increasing lengths
            if(envelopes[i][1] > nums[ans-1])
            {
                nums[ans++] = envelopes[i][1];
            }
            else
            {
                // an envelope with the same length as the current one is already a part of the LIS
                int idx = ceil(envelopes[i][1], nums, ans);
                nums[idx] = envelopes[i][1];
            }
        }
        return ans;
    }
    private int ceil(int target, int[] nums, int len)
    {
        int start=0;
        int end=len-1;
        int ans = -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] >= target)
            {
                ans = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
}