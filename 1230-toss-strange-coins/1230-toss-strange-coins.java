class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] cache = new double[n][target+1];
        for(double[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, target, prob, cache);
    }
    private double getAns(int current, int target, double[] prob, double[][] cache)
    {
        int numberOfCoins = prob.length;
        if(current == numberOfCoins)
        {
            return target == 0 ? 1.0 : 0.0;
        }
        if(cache[current][target] != -1.0)
        {
            return cache[current][target];
        }
        if(target > 0)
        {
            return cache[current][target] = prob[current]*getAns(current+1, target-1, prob, cache) + (1-prob[current])*getAns(current+1, target, prob, cache);
        }
        return cache[current][target] = (1 - prob[current])*getAns(current+1, target, prob, cache);
    }
}