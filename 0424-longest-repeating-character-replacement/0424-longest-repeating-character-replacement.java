class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int n = s.length();
        int[] counts = new int[26];
        int maxFreq = 0;
        int ans = 0;
        while(end < s.length())
        {
            // consume end
            counts[s.charAt(end) - 'A']++;
            maxFreq = Math.max(counts[s.charAt(end) - 'A'], maxFreq);
            end++;
            while(end - start - maxFreq > k)
            {
                counts[s.charAt(start) - 'A']--;
                start++;
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}