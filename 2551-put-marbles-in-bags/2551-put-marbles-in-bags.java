class Solution {
    public long putMarbles(int[] weights, int k) {
        // VVVVI refer to the editorial for intuition
        int n = weights.length;
        int[] splits = new int[n-1];
        for(int i=0; i<n-1; i++)
        {
            splits[i] = weights[i] + weights[i+1];
        }
        long ans = 0;
        Arrays.sort(splits);
        for(int i=0; i<k-1; i++)
        {
            ans += splits[n-2-i] - splits[i];
        }
        return ans;
    }
}