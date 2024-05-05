class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer,Integer> countMap = new TreeMap<>();
        for(int num : nums)
        {
            countMap.put(num, countMap.getOrDefault(num,0) + 1);
        }
        HashMap<Integer,Integer> cache = new HashMap<>();
        return getMaxPoints(countMap.firstKey(), countMap, cache);
    }
    private int getMaxPoints(int current, TreeMap<Integer,Integer> map, HashMap<Integer,Integer> cache)
    {
        if(current == 0)
        {
            return 0;
        }
        if(cache.containsKey(current))
        {
            return cache.get(current);
        }
        int ans = 0;
        var nextKey = map.higherKey(current);
        int notDelete = getMaxPoints(nextKey == null ? 0 : nextKey, map, cache);
        int delete = current*map.get(current);
        if(nextKey != null)
        {
            if(nextKey == current+1)
            {
                var next = map.higherKey(nextKey);
                delete += getMaxPoints(next == null ? 0 : next, map, cache);
            }
            else
            {
                delete += getMaxPoints(nextKey, map, cache);
            }
        }
        ans = Math.max(delete, notDelete);
        cache.put(current, ans);
        return ans;
    }
}