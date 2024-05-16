class Solution {
    public double soupServings(int n) {
        if(n > 4800)
        {
            return 1;
        }
        HashMap<Integer,HashMap<Integer,Double>> cache = new HashMap<>();
        return getAns(n, n, cache);
    }
    private double getAns(int a, int b, HashMap<Integer,HashMap<Integer,Double>> cache)
    {
        if(a == 0 && b == 0)
        {
            return 0.5;
        }
        if(a == 0)
        {
            return 1.0;
        }
        if(b == 0)
        {
            return 0;
        }
        if(cache.containsKey(a) && cache.get(a).containsKey(b))
        {
            return cache.get(a).get(b);
        }
        if(!cache.containsKey(a))
        {
            cache.put(a, new HashMap<>());
        }
        // 4 mutually exclusive events at each step
        double ans = 0;
        int newA, newB;
        
        // type 1
        newA = a - Math.min(100, a);
        newB = b;
        ans += 0.25*getAns(newA, newB, cache);

        // type 2
        newA = a - Math.min(75, a);
        newB = b - Math.min(25, b);
        ans += 0.25*getAns(newA, newB, cache);

        // type 3
        newA = a - Math.min(50, a);
        newB = b - Math.min(50, b);
        ans += 0.25*getAns(newA, newB, cache);

        // type 4
        newA = a - Math.min(25, a);
        newB = b - Math.min(75, b);
        ans += 0.25*getAns(newA, newB, cache);

        cache.get(a).put(b, ans);
        return ans;
    }
}