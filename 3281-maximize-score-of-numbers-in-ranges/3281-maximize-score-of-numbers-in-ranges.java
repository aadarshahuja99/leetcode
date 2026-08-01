class Solution {
    public int maxPossibleScore(int[] start, int d) {
        // similar to aggresive cows
        Arrays.sort(start);
        int s = 0;
        int e = start[start.length-1] + d - start[0];
        int ans = 0;
        while(s <= e)
        {
            int m = s + (e -s)/2;
            if(check(m, start, d))
            {
                ans = m;
                s = m+1;
            }
            else
            {
                e = m-1;
            }
        }
        return ans;
    }
    private boolean check(int m, int[] nums, int d)
    {
        int idx = 1;
        long last = nums[0]*1l;
        while(idx < nums.length)
        {
            if(nums[idx] + d < last + m)
            {
                return false;
            }
            last = nums[idx] > last + m ? (long)nums[idx] : last + (long)m;
            idx++;
        }
        return true;
    }
}