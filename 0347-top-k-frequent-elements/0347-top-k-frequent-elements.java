class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        List<Integer>[] buckets = new List[n];
        for(int num : map.keySet())
        {
            int count = map.get(num);
            if(buckets[count-1] == null)
            {
                buckets[count-1] = new ArrayList<>();
            }
            buckets[count-1].add(num);
        }
        int it = n-1;
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