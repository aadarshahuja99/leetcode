class Solution {
    public int minimumKeypresses(String s) {
        Integer[] counts = new Integer[26];
        Arrays.fill(counts, 0);
        for(char c : s.toCharArray())
        {
            int alphabetIndex = c - 'a';
            counts[alphabetIndex]++;
        }
        Arrays.sort(counts, (a,b) -> {
            return Integer.compare(b,a);
        });
        int ans = 0;
        for(int i=0; i<9; i++)
        {
            ans += counts[i];
        }
        for(int i=9; i<18; i++)
        {
            ans += 2*counts[i];
        }
        for(int i=18; i<26; i++)
        {
            ans += 3*counts[i];
        }
        return ans;
    }
}