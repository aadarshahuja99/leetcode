class Solution {
    public int findPeakElement(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s <= e)
        {
            if(s == e)
            {
                return s;
            }
            int m = s + (e-s)/2;
            if((m > 0 && nums[m] > nums[m-1]) && (m < nums.length-1 && nums[m] > nums[m+1]))
            {
                return m;
            }
            if(m < nums.length-1 && nums[m] < nums[m+1])
            {
                s = m+1;
            }
            else
            {
                e = m-1;
            }
        }
        return 0;
    }
}