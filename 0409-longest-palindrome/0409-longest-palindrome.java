class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        String newString = s.toLowerCase();
        int[] counts = new int[58];
        for(char c : s.toCharArray())
        {
            int index = c - 'A';
            counts[index]++;
        }
        int maxOdd = 0;
        int maxOddChar = -1;
        int ans = 0;
        for(int i=0; i<58; i++)
        {
            if(counts[i] != 0)
            {
                if(counts[i]%2 == 1 && counts[i] > maxOdd)
                {
                    maxOdd = counts[i];
                    maxOddChar = i;
                }
            }
        }
        for(int i=0; i<58; i++)
        {
            if(counts[i] > 0 && (i == maxOddChar || counts[i]%2 == 0))
            {
                ans += counts[i];
            }
            else if(counts[i] > 0 && counts[i]%2 == 1)
            {
                ans += counts[i] - 1;
            }
        }
        return ans;
    }
}