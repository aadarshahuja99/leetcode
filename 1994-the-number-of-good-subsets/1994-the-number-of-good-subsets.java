class Solution {
    int MOD = 1_000_000_007;
    HashMap<Integer, Integer> counts = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public int numberOfGoodSubsets(int[] nums) {
        int n = nums.length;
        boolean[] isValid = new boolean[n];
        HashMap<Integer,Integer> factorToIndexMap = new HashMap<>();
        factorToIndexMap.put(2, 0);
        factorToIndexMap.put(3, 1);
        factorToIndexMap.put(5, 2);
        factorToIndexMap.put(7, 3);
        factorToIndexMap.put(11, 4);
        factorToIndexMap.put(13, 5);
        factorToIndexMap.put(17, 6);
        factorToIndexMap.put(19, 7);
        factorToIndexMap.put(23, 8);
        factorToIndexMap.put(29, 9);
        HashMap<Integer,Integer> factorMap = new HashMap<>();
        for(int num : nums)
        {
            factorize(num, factorMap, factorToIndexMap);
        }
        int maxState = (1<<10);
        int[][] cache = new int[factorMap.size()][maxState];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        int ans = getAns(0, 0, factorMap, cache);
        return ans;
    }

    private int getAns(int current, int state, HashMap<Integer,Integer> factorMap, int[][] cache)
    {
        if(current == list.size())
        {
            return state == 0 ? 0 : 1;
        }
        if(cache[current][state] != -1)
        {
            return cache[current][state];
        }
        int element = list.get(current);
        int notTake = getAns(current+1, state, factorMap, cache);
        if(factorMap.containsKey(element) && ((factorMap.get(element)&state) == 0))
        {
            long take = 0;
            if(element == 1)
            {
                take = ((1l*customPow(counts.get(1)))*(1l*getAns(current+1, state, factorMap, cache)%MOD))%MOD;
            }
            else
            {
                take = ((1l*(counts.get(element))*(1l*getAns(current+1, (state|(factorMap.get(element))), factorMap, cache)%MOD))%MOD + notTake%MOD)%MOD;
            }
            // System.out.println(take+" for "+element+", "+(counts.get(element))+", "+current+" for state "+state);
            return cache[current][state] = (int)take;
        }
        // System.out.println(notTake + " for clash with the current element "+element);
        return cache[current][state] = notTake;
    }

    private int customPow(int p)
    {
        long start = 2l;
        for(int i=0; i<p-1; i++)
        {
            start = (start*2l)%MOD;
        }
        return (int)start;
    }

    private void factorize(int num, HashMap<Integer,Integer> factorMap, HashMap<Integer, Integer> factorToIndexMap)
    {
        if(num == 1)
        {
            if(!factorMap.containsKey(num))
            {
                factorMap.put(num, 0);
                list.add(num);
            }
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            return;
        }
        int temp = num;
        int p = 2;
        HashSet<Integer> current = new HashSet<>();
        while(p*p <= num)
        {
            while(num%p == 0)
            {
                if(current.contains(p))
                {
                    return;
                }
                current.add(p);
                num = num/p;
            }
            p++;
        }
        if(num > 1)
        {
            if(current.contains(num))
            {
                return;
            }
            current.add(num);
        }
        int mask = 0;
        for(int fact : current)
        {
            mask = (mask|(1<<factorToIndexMap.get(fact)));
        }
        if(!factorMap.containsKey(temp))
        {
            factorMap.put(temp, mask);
            list.add(temp);
        }
        counts.put(temp, counts.getOrDefault(temp, 0) + 1);
    }
}