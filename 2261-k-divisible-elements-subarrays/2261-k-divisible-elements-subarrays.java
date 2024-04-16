class Solution {
    int prime = 31;
    long mod = 45887423068929227L;
    HashSet<Long> hash = new HashSet<>();
    int ans;
    public int countDistinct(int[] nums, int k, int p) {
        long[] roll = new long[nums.length];
        roll[0] = 1;
        for(int i=1; i<nums.length; i++)
        {
            roll[i] = (roll[i-1]*prime)%mod;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            long currentHash = 0;
            int count = 0;
            for(int j=i; j<nums.length; j++)
            {
                currentHash = ((199*currentHash) + nums[j]);
                if(nums[j]%p == 0)
                {
                    count++;
                }
                if(count <= k && hash.add(currentHash))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}