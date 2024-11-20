class Solution {
    public int takeCharacters(String s, int k) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int i = 0;
        int j = 0;
        int n = s.length();
        if(k == 0)
        {
            return 0;
        }
        while(i < n)
        {
            if(s.charAt(i) == 'a')
            {
                aCount++;
            }
            else if(s.charAt(i) == 'b')
            {
                bCount++;
            }
            else
            {
                cCount++;
            }
            if(aCount >= k && bCount >= k && cCount >= k)
            {
                break;
            }
            i++;
        }
        int ans = 0;
        if(aCount >= k && bCount >= k && cCount >= k)
        {
            ans = i+1;
        }
        else
        {
            return -1;
        }
        j = n-1;
        while(j >= 0)
        {
            if(s.charAt(j) == 'a')
            {
                aCount++;
            }
            else if(s.charAt(j) == 'b')
            {
                bCount++;
            }
            else
            {
                cCount++;
            }
            j--;
            if(aCount >= k && bCount >= k && cCount >= k && i >= 0)
            {
                while(i >= 0)
                {
                    if(s.charAt(i) == 'a')
                    {
                        aCount--;
                    }
                    else if(s.charAt(i) == 'b')
                    {
                        bCount--;
                    }
                    else
                    {
                        cCount--;
                    }
                    i--;
                    if(aCount >= k && bCount >= k && cCount >= k)
                    {
                        // System.out.println("found candidate for "+i+", "+j+" "+(i+1 + n-1-j));
                        ans = Math.min(ans, i+1 + n-1-j);
                    }
                    else
                    {
                        break;
                    }
                }
            }
            else if(aCount >= k && bCount >= k && cCount >= k)
            {
                ans = Math.min(ans, n-1-j);
            }
        }
        return ans;
    }
}