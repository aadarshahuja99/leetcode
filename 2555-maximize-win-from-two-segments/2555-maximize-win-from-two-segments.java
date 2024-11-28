class Solution {
    public int maximizeWin(int[] prizePositions, int len) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        TreeMap<Integer,Integer> counts = new TreeMap<>();
        HashMap<Integer, Integer> keyToIndex = new HashMap<>();
        int n = prizePositions.length;
        System.out.println(n);
        int total = 0;
        for(int i=0; i<n; i++)
        {
            int val = prizePositions[i];
            if(!counts.containsKey(val))
            {
                // System.out.println("added "+val+" to counts");
                counts.put(val, 0);
            }
            counts.put(val, counts.get(val) + 1);
        }
        int[] keys = new int[counts.size()];
        // System.out.println(keys.length+" "+counts.size()+" unique");
        int it = 0;
        for(int k : counts.keySet())
        {
            if(!map.containsKey(k))
            {
                map.put(k, 0);
            }
            map.put(k, total);
            total += counts.get(k);
            keys[it] = k;
            keyToIndex.put(k, it);
            it++;
        }
        // for(int k : keys)
        // {
        //     System.out.println(k+" has index "+keyToIndex.get(k));
        // }
        int[][] cache = new int[keys.length][3];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, 0, keys, map, counts, keyToIndex, len, cache);
    }
    private int getAns(int current, int selected, int[] keys, TreeMap<Integer,Integer> map, TreeMap<Integer,Integer> counts, HashMap<Integer,Integer> keyToIndex, int k, int[][] cache)
    {
        if(current == keys.length)
        {
            if(selected == 0)
            {
                return Integer.MIN_VALUE;
            }
            return 0;
        }
        if(selected == 2)
        {
            return 0;
        }
        if(cache[current][selected] != -1)
        {
            return cache[current][selected];
        }
        var floor = map.floorKey(keys[current] + k);
        // System.out.println(floor+" is floor key for "+(keys[current]+k));
        int notTake = getAns(current+1, selected, keys, map, counts, keyToIndex, k, cache);
        if(floor == null)
        {
            return cache[current][selected] = notTake;
        }
        int nextIndex = keyToIndex.get(floor) + 1;
        // System.out.println((map.get(floor) + counts.get(floor))+" "+notTake+" nextIndex: "+nextIndex);
        return cache[current][selected] = Math.max(notTake, map.get(floor) + counts.get(floor) - map.get(keys[current]) + getAns(nextIndex, selected + 1, keys, map, counts, keyToIndex, k, cache));
    }
}