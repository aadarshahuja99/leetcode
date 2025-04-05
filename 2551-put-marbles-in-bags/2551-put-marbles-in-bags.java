class Solution {
    public long putMarbles(int[] weights, int k) {
        // VVVVI refer to the editorial for intuition
        int n = weights.length;
        int[] modified = new int[n-1];
        for(int i=0; i<n-1; i++)
        {
            modified[i] = weights[i] + weights[i+1];
        }
        long ans = 0;
        Arrays.sort(modified);
        for(int i=0; i<k-1; i++)
        {
            ans += modified[n-2-i] - modified[i];
        }
        return ans;
    }
}