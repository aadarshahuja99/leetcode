class Solution {
    public int minimumChairs(String s) {
        int current = 0;
        int max = 0;
        for(char c : s.toCharArray())
        {
            if(c == 'E')
            {
                current++;
            }
            else
            {
                current--;
            }
            max = Math.max(current, max);
        }
        return max;
    }
}