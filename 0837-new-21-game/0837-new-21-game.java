class Solution {
    public double new21Game(int n, int k, int maxPoints) {
        double[] cache = new double[k+maxPoints];
         
        // Arrays.fill(cache, -1);
        
        // top down code
        // convert BC of recursion to initialze the cache matrix
        double probabilitySum = 0;
        for(int current = k+maxPoints-1; current >= k; current--)
        {
            if(current <= n)
            {
                cache[current] = 1;
            }
            else
            {
                cache[current] = 0;
            }
            probabilitySum += cache[current];
        }
        
        for(int current = k-1; current >= 0; current--)
        {
            double ans = 0;
            double multiplier = 1.0/(double)maxPoints;
            ans = probabilitySum*multiplier;
            cache[current] = ans;
            // move the window towards left
            probabilitySum -= cache[current + maxPoints];
            probabilitySum += cache[current];
        }

        return cache[0];
    }
    private double getAns(int current, int n, int k, int maxPoints, double[] cache)
    {
        if(current >= k)
        {
            return current <= n ? 1.0 : 0;
        }
        if(cache[current] != -1)
        {
            return cache[current];
        }
        double ans = 0;
        double multiplier = 1.0/(double)maxPoints;
        for(int i=1; i<=maxPoints; i++)
        {
            ans += multiplier*getAns(current+i, n, k, maxPoints, cache);
        }
        return cache[current] = ans;
    }
}