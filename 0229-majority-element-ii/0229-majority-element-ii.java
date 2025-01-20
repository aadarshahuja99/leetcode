class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int num : nums)
        {
            if(cnt1 == 0 && element2 != num)
            {
                cnt1++;
                element1 = num;
            }
            else if(cnt2 == 0 && element1 != num)
            {
                cnt2++;
                element2 = num;
            }
            else if(element1 == num)
            {
                cnt1++;
            }
            else if(element2 == num)
            {
                cnt2++;
            }
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        int actualCount1 = 0;
        int actualCount2 = 0;
        for(int num : nums)
        {
            if(element1 == num)
            {
                actualCount1++;
            }
            else if(element2 == num)
            {
                actualCount2++;
            }
        }
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(actualCount1 > (int)Math.floor(n/3))
        {
            ans.add(element1);
        }
        if(actualCount2 > (int)Math.floor(n/3))
        {
            ans.add(element2);
        }
        return ans;
    }
}