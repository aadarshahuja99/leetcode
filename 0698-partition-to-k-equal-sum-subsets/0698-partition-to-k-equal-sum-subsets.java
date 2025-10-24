class Solution {
    private boolean getAns(int state, int count, int sum, int target, int k, int[] arr, Boolean[][] cache) {
                                  
        int n = arr.length;
        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) { 
            return state != (1<<(n)-1);
        }
        if(sum == target)
        {
            return getAns(state, count+1, 0, target, k, arr, cache);
        }
        if(cache[state][count] != null)
        {
            return cache[state][count];
        }
        boolean ans = false;
        for(int i=0; i<n; i++)
        {
            if((state&(1<<i)) == 0 && (sum + arr[i]) <= target)
            {
                ans = ans || getAns((state^(1<<i)), count, sum+arr[i], target, k, arr, cache);
                if(ans)
                {
                    return cache[state][count] = true;
                }
            }
        }
        return cache[state][count] = ans;
    }
  
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
             totalArraySum += arr[i];
        }
        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) { 
            return false;
        }
        int targetSum = totalArraySum / k;
        Integer mask = 0;
        // Memoize the ans using taken element's string as key.
        Boolean[][] memo = new Boolean[(1<<(n))][k-1];
      
        return getAns(0, 0, 0, targetSum, k, arr, memo);
    }
}