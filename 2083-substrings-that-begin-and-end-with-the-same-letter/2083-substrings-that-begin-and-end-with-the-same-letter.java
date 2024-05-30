class Solution {
    public long numberOfSubstrings(String s) {
        int[] count = new int[26];
        long ans = 0l;
        for(char c : s.toCharArray())
        {
            int index = c - 'a';
            count[index]++;
            ans += 1L*count[index];
        }
        return ans;
    }
}