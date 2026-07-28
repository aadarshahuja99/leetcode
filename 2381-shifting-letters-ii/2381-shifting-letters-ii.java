class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        // accumulate the total number of shifts per index using line sweep
        int n = s.length();
        long[] operations = new long[n+1];
        for(int[] shift : shifts)
        {
            int dir = shift[2];
            if(dir == 1)
            {
                operations[shift[0]] += 1;
                operations[shift[1]+1] -= 1;
            }
            else
            {
                operations[shift[0]] -= 1;
                operations[shift[1]+1] += 1;
            }
        }
        for(int i=1; i<n; i++)
        {
            operations[i] += operations[i-1];
        }
        char[] chars = new char[n];
        for(int i=0; i<n; i++)
        {
            chars[i] = (char)(97+(((long)s.charAt(i)-97l+operations[i])%26 + 26)%26);
        }
        return new String(chars);
    }
}