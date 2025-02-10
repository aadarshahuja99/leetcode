class Solution {
    int MOD = Integer.MAX_VALUE;
    int base = 29;
    public int longestRepeatingSubstring(String s) {
        int min = 1;
        int n = s.length();
        // System.out.println("len: "+n);
        if(n == 1)
        {
            return 0;
        }
        int max = n-1;
        int ans = 0;
        while(min <= max)
        {
            int mid = min + (max - min)/2;
            if(check(mid, s))
            {
                ans = mid;
                min = mid+1;
            }
            else
            {
                max = mid-1;
            }
        }
        return ans;
    }
    private boolean check(int len, String s)
    {
        long hash = 0;
        int l = 0;
        int r = 0;
        int n = s.length();
        long hashVal = 1l;
        for(int i=0; i<len-1; i++)
        {
            hashVal = (hashVal*base)%MOD;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r < n)
        {
            int ch = s.charAt(r) - 'a' + 1;
            hash = ((hash*base)%MOD + ch)%MOD;
            r++;
            // System.out.println(hash+" at "+l+","+r);
            if(r - l == len)
            {
                if(map.containsKey((int)hash))
                {
                    int st = map.get((int)hash);
                    if(s.substring(st,st+len).equals(s.substring(l,r)))
                    {
                        return true;
                    }
                }
                else
                {
                    // System.out.println("putting hash in map");
                    map.put((int)hash, l);
                }
                int chStart = s.charAt(l) - 'a' + 1;
                hash = (hash + MOD - ((hashVal*chStart)%MOD))%MOD;
                // System.out.println(hash+" after moving l to "+(l+1));
                l++;
            }
        }
        return false;
    }
}