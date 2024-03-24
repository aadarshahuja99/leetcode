class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        int n = code.length;
        int[] pre = new int[n];
        for(int i=1; i<n; i++)
        {
            pre[i] = pre[i-1] + code[i-1];
        }
        int[] post = new int[n];
        for(int j=n-2; j>=0; j--)
        {
            post[j] = post[j+1] + code[j+1];
        }
        if(k < 0)
        {
            for(int i=0; i < n; i++)
            {
                if(i+k < 0)
                {
                    int idx = n-1-Math.abs(i+k);
                    ans[i] = pre[i] + post[idx];
                }
                else
                {
                    ans[i] = pre[i] - pre[i+k];
                }
            }
        }
        else if(k > 0)
        {
            for(int i=0; i < n; i++)
            {
                if(i+k > n-1)
                {
                    int idx = i+k - (n-1);
                    ans[i] = post[i] + pre[idx];
                }
                else
                {
                    ans[i] = post[i] - post[i+k];
                }
            }
        }
        return ans;
    }
}