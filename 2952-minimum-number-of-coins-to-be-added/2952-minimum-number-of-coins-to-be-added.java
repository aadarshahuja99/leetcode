class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int count = 0;
        int lastCovered = 0;
        int idx = 0;
        int n = coins.length;
        while(lastCovered < target)
        {
            // System.out.println(lastCovered+" "+count);
            int missing = lastCovered + 1;
            if(idx < n && coins[idx] <= missing)
            {
                lastCovered += coins[idx];
                idx++;
            }
            else
            {
                lastCovered += missing;
                count++;
            }
        }
        return count;
    }
}