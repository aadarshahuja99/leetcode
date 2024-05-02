class Solution {
    public int numberOfSubstrings(String s) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int start = 0;
        int end = 0;
        int length = s.length();
        int ans = 0;
        while(end < length)
        {
            char endChar = s.charAt(end);
            if(endChar == 'a')
            {
                aCount++;
            }
            else if(endChar == 'b')
            {
                bCount++;
            }
            else
            {
                cCount++;
            }
            end++;
            if(aCount > 0 && bCount > 0 && cCount > 0)
            {
                // we have a candidate
                int currentCount = 0;
                while(aCount > 0 && bCount > 0 && cCount > 0)
                {
                    currentCount++;
                    if(s.charAt(start) == 'a'){
                        aCount--;
                    }
                    else if(s.charAt(start) == 'b')
                    {
                        bCount--;
                    }
                    else
                    {
                        cCount--;
                    }
                    start++;
                }
                ans += currentCount*(length - end + 1);
            }
        }
        if(aCount > 0 && bCount > 0 && cCount > 0)
        {
            // we have a candidate
            int currentCount = 0;
            while(aCount > 0 && bCount > 0 && cCount > 0)
            {
                currentCount++;
                if(s.charAt(start) == 'a'){
                    aCount--;
                }
                else if(s.charAt(start) == 'b')
                {
                    bCount--;
                }
                else
                {
                    cCount--;
                }
                start++;
            }
            ans += currentCount;
        }
        return ans;
    }
}