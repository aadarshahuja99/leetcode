class Solution {
    public long countVowels(String word) {
        long ans = 0l;
        int idx = 0;
        for(char ch : word.toCharArray())
        {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                ans += 1l*(idx+1)*(word.length() - idx);
            }
            idx++;
        }
        return ans;
    }
}