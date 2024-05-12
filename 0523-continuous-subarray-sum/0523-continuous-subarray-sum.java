class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer,Integer> moduloFirstIndexes = new HashMap<>();
        int idx = 0;
        moduloFirstIndexes.put(0, -1);
        for(int num : nums)
        {
            sum += num;
            if(moduloFirstIndexes.containsKey(sum%k))
            {
                if((idx - moduloFirstIndexes.get(sum%k)) >= 2)
                {
                    return true;
                }
            }
            else
            {
                moduloFirstIndexes.put(sum%k, idx);
            }
            idx++;
        }
        return false;
    }
}