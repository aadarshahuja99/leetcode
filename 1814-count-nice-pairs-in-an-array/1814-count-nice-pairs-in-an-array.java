class Solution {
    public int countNicePairs(int[] nums) {
        // same approach as number of bad pairs
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int numberOfNicePairs = 0;
        int modulo = 1000000007;
        for(int i=0; i<n; i++)
        {
            int temp = nums[i];
            int multiplier = 10;
            int rev = 0;
            while(temp > 0)
            {
                int rem = temp%10;
                temp = temp/10;
                rev = rev*multiplier + rem;
            }
            if(map.containsKey(nums[i] - rev))
            {
                int existing = map.get(nums[i] - rev);
                numberOfNicePairs = (numberOfNicePairs%modulo + existing%modulo)%modulo;
                map.put(nums[i] - rev, existing+1);
            }
            else
            {
                map.put(nums[i] - rev, 1);
            }
        }
        return numberOfNicePairs;
    }
}