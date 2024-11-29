class Solution {
    public int countPalindromes(String s) {
        int n = s.length();
        HashMap<Integer, Integer> seenBefore = new HashMap<>();
        HashMap<Integer, Integer> seenAfter = new HashMap<>();
        int[][][] before = new int[n][10][10];
        int[][][] after = new int[n][10][10];
        for(int it = 0; it < n-2; it++)
        {
            char c = s.charAt(it);
            int digit = c - 48;
            if(it < n-1)
            {
                for(int j=0; j<10; j++)
                {
                    for(int k=0; k<10; k++)
                    {
                        before[it+1][j][k] = before[it][j][k];
                        if(k == digit)
                        {
                            before[it+1][j][k] += seenBefore.getOrDefault(j, 0);
                        }
                    }
                }
            }
            seenBefore.put(digit, seenBefore.getOrDefault(digit,0) + 1);
        }
        for(int i=n-1; i>=2; i--)
        {
            char c = s.charAt(i);
            int digit = c - 48;
            for(int j=0; j<10; j++)
            {
                for(int k=0; k<10; k++)
                {
                    after[i-1][j][k] = after[i][j][k];
                    if(j == digit)
                    {
                        after[i-1][j][k] += seenAfter.getOrDefault(k, 0);
                    }
                }
            }
            seenAfter.put(digit, seenAfter.getOrDefault(digit,0) + 1);
        }
        long ans = 0;
        int mod = 1_000_000_007;
        for(int i=2; i<=n-3; i++)
        {
            for(int j=0; j<10; j++)
            {
                for(int k=0; k<10; k++)
                {
                    // System.out.println("for i = "+i+" j = "+j+" k = "+k+" aft: "+after[i][k][j]+" bef "+before[i][j][k]);
                    ans = (ans%mod + (1l*before[i][j][k] * 1l*after[i][k][j])%mod)%mod;
                }
            }
        }
        return (int)ans;
    }
}