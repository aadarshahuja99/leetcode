class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[26];
        for(char c : s.toCharArray())
        {
            int index = c - 97;
            map[index] += 1;
        }
        int oddCount = 0;
        for(int i : map)
        {
            if(i%2 == 1)
            {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}