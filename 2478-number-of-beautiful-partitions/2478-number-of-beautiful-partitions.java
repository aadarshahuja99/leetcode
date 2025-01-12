class Solution {
    int MOD = 1_000_000_007;
    public int beautifulPartitions(String s, int k, int minLength) {
        if(!isPrime(s.charAt(0) - '0') || s.length() == 1 || isPrime(s.charAt(s.length() - 1) - '0'))
        {
            return 0;
        }
        int[][] cache = new int[s.length()][k];
        for(int[] r : cache)
        {
            Arrays.fill(r, -1);
        }
        return getAns(minLength, k-1, minLength, s, cache);
    }
    private boolean isPrime(int current)
    {
        return current == 2 || current == 3 || current == 5 || current == 7;
    }
    private int getAns(int current, int k, int minLength, String s, int[][] cache)
    {
        if(current == s.length())
        {
            return k == 0 ? 1 : 0;
        }
        if(k == 0)
        {
            return (s.length() - current < minLength) ? 0 : 1;
        }
        if(cache[current][k] != -1)
        {
            return cache[current][k];
        }
        int notTake = getAns(current+1, k, minLength, s, cache);
        if(isPrime(s.charAt(current) - '0') && !isPrime(s.charAt(current-1) - '0'))
        {
            return cache[current][k] = (getAns(Math.min(current+minLength, s.length()), k-1, minLength, s, cache)%MOD + notTake%MOD)%MOD;
        }
        return cache[current][k] = notTake%MOD;
    }
}