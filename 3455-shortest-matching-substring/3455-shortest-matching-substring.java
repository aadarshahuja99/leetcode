class Solution {
    public int shortestMatchingSubstring(String s, String p) {
        String[] ar = p.split("\\*");
        List<String> valid = new ArrayList<>();
        if(ar.length == 0)
        {
            return 0;
        }
        for(String pa : ar)
        {
            if(pa != "")
            {
                valid.add(pa);
            }
        }
        if(valid.size() == 1)
        {
            int l1 = valid.get(0).length();
            var a1 = search(s, valid.get(0));
            return a1.size() > 0 ? l1 : -1;
        }
        else if(valid.size() == 2)
        {
            int l1 = valid.get(0).length();
            int l2 = valid.get(1).length();
            var a1 = search(s, valid.get(0));
            var a2 = search(s, valid.get(1));
            if(a1.size() == 0 && a2.size() == 0)
            {
                return -1;
            }
            int ans = Integer.MAX_VALUE;
            for(int a : a1)
            {
                int c1 = getCeil(a2, a+l1);
                if(c1 == -1)
                {
                    break;
                }
                ans = Math.min(ans, c1 + l2 - a);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
        else
        {
            int l1 = valid.get(0).length();
            int l2 = valid.get(1).length();
            int l3 = valid.get(2).length();
            var a1 = search(s, valid.get(0));
            var a2 = search(s, valid.get(1));
            var a3 = search(s, valid.get(2));
            if(a1.size() == 0 && a2.size() == 0 && a3.size() == 0)
            {
                return -1;
            }
            int ans = Integer.MAX_VALUE;
            for(int a : a1)
            {
                int c1 = getCeil(a2, a+l1);
                if(c1 == -1)
                {
                    break;
                }
                int c2 = getCeil(a3, c1+l2);
                if(c2 == -1)
                {
                    break;
                }
                ans = Math.min(ans, c2 + l3 - a);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
    private int getCeil(List<Integer> list, int t)
    {
        int ans = -1;
        int s = 0;
        int e = list.size() - 1;
        while(s <= e)
        {
            int m = s + (e - s)/2;
            if(list.get(m) >= t)
            {
                ans = list.get(m);
                e = m-1;
            }
            else
            {
                s = m+1;
            }
        }
        return ans;
    }
    private List<Integer> search(String s, String p)
    {
        char[] a = p.toCharArray();
        var lps = getLPS(a);
        int i=0;
        int j=0;
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        while(i < n && j < m)
        {
            if(s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }
            else if(j == 0)
            {
                i++;
            }
            else
            {
                j = lps[j-1];
            }
            if(j == m)
            {
                ans.add(i-m);
                j = lps[j-1];
            }
        }
        return ans;
    }
    private int[] getLPS(char[] a)
    {
        int i=1;
        int j=0;
        int n = a.length;
        int[] lps = new int[n];
        while(i<n)
        {
            if(a[i] == a[j])
            {
                lps[i] = ++j;
                i++;
            }
            else if(j == 0)
            {
                i++;
            }
            else
            {
                j = lps[j-1];
            }
        }
        return lps;
    }
}