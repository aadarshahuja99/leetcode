class Solution {
    public long countBadPairs(int[] nums) {
        // rephrase the inequality. Find the number of pairs that satisfy the euality and subtract them from n(n-1)/2
        HashMap<Integer,Integer> map = new HashMap<>();
        long goodPairs = 0;
        long n = nums.length;
        for(int i=0; i<n; i++)
        {
            int candidate = nums[i]-i;
            if(map.containsKey(candidate))
            {
                goodPairs += map.get(candidate);
                map.put(candidate, map.get(candidate)+1);
            }
            else
            {
                map.put(candidate,1);
            }
        }
        long totalPairs = n*(n-1)/2;
        return totalPairs - goodPairs;
    }
}