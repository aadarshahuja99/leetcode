class Solution {
    public String[] shortestSubstrings(String[] arr) {
        String[] ans = new String[arr.length];
        int idx = 0;
        for(String s : arr)
        {
            String candidate = "zzzzzzzzzzzzzzzzzzzzz";
            for(int i=0; i<s.length(); i++)
            {
                String current = String.valueOf(s.charAt(i));
                for(int j=i; j<s.length(); j++)
                {
                    if(j!=i)
                    {
                        current += String.valueOf(s.charAt(j));
                    }
                    boolean isCandidate = true;
                    // traverse the entire array for the current substring
                    for(int k=0; k<arr.length; k++)
                    {
                        if(k==idx)
                        {
                            continue;
                        }
                        String text = arr[k];
                        if(!applyKMP(text, current))
                        {
                            isCandidate = false;
                            break;
                        }
                    }
                    if(isCandidate)
                    {
                        // System.out.println("found a candidate: "+current+" for idx "+idx);
                        if(current.length() < candidate.length() || (current.length() == candidate.length() && current.compareTo(candidate) < 0))
                        {
                            candidate = current;
                        }
                    }
                }
            }
            if(candidate.equals("zzzzzzzzzzzzzzzzzzzzz"))
            {
                ans[idx] = "";
            }
            else
            {
                ans[idx] = candidate;
            }
            idx++;
        }
        return ans;
    }
    private boolean applyKMP(String s, String target)
    {
        int[] lps = new int[target.length()];
        int i=1;
        int prev=0;
        while(i<target.length())
        {
            if(target.charAt(i) == target.charAt(prev))
            {
                lps[i] = prev+1;
                i++;
                prev++;
            }
            else if(prev == 0)
            {
                lps[i] = 0;
                i++;
            }
            else
            {
                prev = lps[prev-1];
            }
        }
        int idx = 0;
        int j = 0;
        while(idx < s.length())
        {
            if(s.charAt(idx) == target.charAt(j))
            {
                idx++;
                j++;
            }
            else
            {
                if(j==0)
                {
                    idx++;
                }
                else
                {
                    j = lps[j-1];
                }
            }
            if(j==target.length())
            {
                return false;
            }
        }
        // System.out.println();
        return true;
    }
}