class Solution {
    public void reverseWords(char[] s) {
        // reverse the entire string and then reverse individual words
        // similar approach to reverse array question
        int n=s.length;
        int start=0;
        int end=n-1;
        reverseUtil(start, end, s);
        while(start <= n-1)
        {
            int j=start;
            while(j < n && s[j] != ' ')
            {
                j++;
            }
            reverseUtil(start, j-1, s);
            start = j+1;
        }
    }
    private void reverseUtil(int start, int end, char[] s)
    {
        while(start < end)
        {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}