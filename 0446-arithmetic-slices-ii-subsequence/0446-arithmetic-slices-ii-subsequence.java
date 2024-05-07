class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
        {
            return 0;
        }
        int n = nums.length;
        HashMap<Integer,HashMap<Integer,Integer>> dp = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            dp.put(i,new HashMap<>());
        }
        int ans = 0;
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                long diff = (long)nums[i] - (long)nums[j];
                if(diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE)
                {
                    continue;
                }
                int numberOfSubequencesOfLength2orMoreEndingAtJ = dp.get(j).getOrDefault((int)diff, 0);
                int numberOfSubequencesOfLength2orMoreEndingAtI = dp.get(i).getOrDefault((int)diff, 0);
                ans += numberOfSubequencesOfLength2orMoreEndingAtJ;
                dp.get(i).put((int)diff, numberOfSubequencesOfLength2orMoreEndingAtJ
                + numberOfSubequencesOfLength2orMoreEndingAtI + 1); // a +1 is added because
                // the current element 'i' can form a subsequence with each of the 'j' elements subsequences and a subsequence with the entire j element ending subsequence as well
            }
        }
        return ans;
    }
}