class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(num));
        }
        List<Integer>[] buckets = new List[maxFrequency];
        for(int num : map.keySet())
        {
            int frequency = map.get(num);
            if(buckets[frequency-1] == null)
            {
                buckets[frequency-1] = new ArrayList<>();
            }
            buckets[frequency-1].add(num);
        }
        int it = maxFrequency-1;
        int[] ans = new int[k];
        int idx = 0;
        while(k > 0)
        {
            if(buckets[it] == null)
            {
                it--;
            }
            else
            {
                for(int num : buckets[it])
                {
                    ans[idx] = num;
                    idx++;
                    k--;
                    if(k == 0)
                    {
                        break;
                    }
                }
                it--;
            }
        }
        return ans;
    }
}