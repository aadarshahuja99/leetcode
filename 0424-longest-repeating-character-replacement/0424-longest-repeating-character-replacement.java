class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int n = s.length();
        int[] counts = new int[26];
        int maxIndex = 0;
        int ans = 0;
        while(end < s.length())
        {
            if(end - start - counts[maxIndex] <= k)
            {
                ans = Math.max(ans, end - start);
                // System.out.println("1: "+start+" "+end);
                counts[s.charAt(end) - 'A']++;
                if(counts[s.charAt(end) - 'A'] > counts[maxIndex])
                {
                    maxIndex = s.charAt(end) - 'A';
                }
                end++;
            }
            else
            {
                counts[s.charAt(start) - 'A']--;
                start++;
                int newMaxIndex = maxIndex;
                for(int i=0; i<26; i++)
                {
                    if(counts[i] > counts[newMaxIndex])
                    {
                        newMaxIndex = i;
                    }
                }
                maxIndex = newMaxIndex;
            }
        }
        if(end - start - counts[maxIndex] <= k)
        {
            ans = Math.max(ans, end - start);
            // System.out.println(start+" "+end);
        }
        return ans;
    }
}