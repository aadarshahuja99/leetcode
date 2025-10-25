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
            // if the window ending at the end-th guy is invalid, then make it valid
            while(end - start - maxFreq > k)
            {
                // no need to update the maximum frequency again and again as for example if the current maxFreq is x then the next candidate which will give a possible longer answer has to have the maxFreq to be at least x+1, during shrinking, the maxFreq value will only decrease and that computation is not needed for computing the answer
                counts[s.charAt(start) - 'A']--;
                start++;
            }
            // compute the longest valid window ending at the end-th guy with the answer
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}
