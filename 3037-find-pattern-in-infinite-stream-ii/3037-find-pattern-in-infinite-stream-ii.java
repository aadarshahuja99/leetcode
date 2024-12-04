/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 *     public InfiniteStream(int[] bits);
 *     public int next();
 * }
 */
class Solution {
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        int n=pattern.length;
        int current = infiniteStream.next();
        int j=0;
        int index = 0;
        int[] lps = getLPS(pattern);
        while(true)
        {
            if(current == pattern[j])
            {
                current = infiniteStream.next();
                j++;
                index++;
            }
            else
            {
                if(j == 0)
                {
                    current = infiniteStream.next();
                    index++;
                }
                else
                {
                    j = lps[j-1];
                }
            }
            if(j == n)
            {
                return index - n;
            }
        }
    }
    private int[] getLPS(int[] p)
    {
        int n=p.length;
        int i=1;
        int[] lps = new int[n];
        int length=0;
        while(i < n)
        {
            if(p[i] == p[length])
            {
                lps[i] = ++length;
                i++;
            }
            else if(length == 0)
            {
                i++;
            }
            else
            {
                length = lps[length-1];
            }
        }
        return lps;
    }
}