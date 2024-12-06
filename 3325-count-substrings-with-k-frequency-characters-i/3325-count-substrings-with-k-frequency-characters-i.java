class Solution {
    public int numberOfSubstrings(String s, int k) {
        int[] counts = new int[26];
        int left=0;
        int j=0;
        int n = s.length();
        int ans = 0;
        while(j < n)
        {
            int alphabet = s.charAt(j) - 'a';
            counts[alphabet]++;
            j++;
            if(counts[alphabet] == k)
            {
                int start = left;
                while(counts[alphabet] == k)
                {
                    int newAlphabet = s.charAt(left) - 'a';
                    counts[newAlphabet]--;
                    left++;
                }
                int leftSegmentLength = left - start;
                ans += leftSegmentLength*(n-j+1);
            }
        }
        return ans;
    }
}