class Solution {
    public int findLUSlength(String[] strs) {
        int m = strs.length;
        int ans = 0;
        for(int i=0; i<m; i++)
        {
            int cnt = 0;
            for(int j=0; j<m; j++)
            {
                if(i == j)
                {
                    continue;
                }
                int l=0;
                int k=0;
                while(l < strs[i].length() && k < strs[j].length())
                {
                    if(strs[i].charAt(l) != strs[j].charAt(k))
                    {
                        k++;
                    }
                    else
                    {
                        l++;
                        k++;
                    }
                }
                if(l < strs[i].length())
                {
                    cnt++;
                }
            }
            // System.out.println(cnt+" for "+strs[i]);
            if(cnt == m-1)
            {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans == 0 ? -1 : ans;
    }
}