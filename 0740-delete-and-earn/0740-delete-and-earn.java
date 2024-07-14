class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer,Integer> countMap = new TreeMap<>();
        for(int num : nums)
        {
            countMap.put(num, countMap.getOrDefault(num,0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int k : countMap.keySet())
        {
            list.add(k);
        }
        int[] cache = new int[list.size()];
        Arrays.fill(cache, -1);
        return getMaxPoints(0, countMap, cache, list);
    }
    private int getMaxPoints(int current, TreeMap<Integer,Integer> map, int[] cache, ArrayList<Integer> list)
    {
        if(current >= list.size())
        {
            return 0;
        }
        if(cache[current] != -1)
        {
            return cache[current];
        }
        int ans = 0;
        var nextKey = current;
        int val = list.get(current);
        while(nextKey < list.size() && list.get(nextKey) <= val+1)
        {
            nextKey++;
        }
        int nextKey1 = current;
        while(nextKey1 < list.size() && list.get(nextKey1) == val)
        {
            nextKey1++;
        }
        int notDelete = getMaxPoints(nextKey1, map, cache, list);
        int delete = val*map.get(val) + getMaxPoints(nextKey, map, cache, list);
        // System.out.println(notDelete+" "+delete+" "+ nextKey +"," + nextKey1 + " for " +val);
        ans = Math.max(delete, notDelete);
        cache[current] = ans;
        return ans;
    }
}