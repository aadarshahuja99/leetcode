class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[] pre = new int[n];
        int[] post = new int[n];
        HashSet<Character> charsFromStart = new HashSet<>();
        HashSet<Character> charsFromEnd = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            pre[i] = charsFromStart.size();
            charsFromStart.add(s.charAt(i));
        }
        int ans = 0;
        for(int i=n-1; i>=0; i--)
        {
            charsFromEnd.add(s.charAt(i));
            post[i] = charsFromEnd.size();
            if(post[i] == pre[i])
            {
                ans++;
            }
        }
        return ans;
    }
}