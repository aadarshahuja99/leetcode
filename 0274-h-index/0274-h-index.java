class Solution {
    public int hIndex(int[] citations) {
        // use running sum + array (meetings 2)
        int max = citations[0];
        // HashSet<Integer> set = new HashSet<>();
        // set.add(citations[0]);
        for(int i=1; i<citations.length; i++)
        {
            max = Math.max(max, citations[i]);
            // set.add(citations[i]);
        }
        int[] nums = new int[max+1];
        for(int citation : citations)
        {
            nums[citation]++;
        }
        if(nums[max] >= max)
        {
            return max;
        }
        for(int i=max-1; i>=0; i--)
        {
            nums[i] += nums[i+1];
            // System.out.println(i+" "+nums[i]);
            if(nums[i] >= i)
            {
                return i;
            }
        }
        return -1;
    }
}