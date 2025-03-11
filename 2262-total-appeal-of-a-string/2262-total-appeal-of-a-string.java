class Solution {
    public long appealSum(String s) {
        int[] last = new int[26];
        Arrays.fill(last,-1);
        last[s.charAt(0)-97] = 0;
        long lastDp = 1l;
        long ans = 1;
        for(int i=1; i<s.length(); i++)
        {
            int alphabetIndex = s.charAt(i) - 'a';
            long currentDp = 0l;
            if(last[alphabetIndex] == -1)
            {
                currentDp = lastDp + i+1;
            }
            else
            {
                currentDp = lastDp + i-last[alphabetIndex];
            }
            last[alphabetIndex] = i;
            ans += currentDp;
            lastDp = currentDp;
        }
        return ans;
    }
}