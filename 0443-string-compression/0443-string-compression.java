class Solution {
    public int compress(char[] chars) {
        int i=0;
        int n = chars.length;
        String compressed = "";
        while(i < n)
        {
            int j = i;
            int count = 0;
            compressed += chars[i];
            while(j < n && chars[j] == chars[i])
            {
                j++;
                count++;
            }
            if(count > 1)
            {
                compressed += count;
            }
            i = j;
        }
        for(int it=0; it<compressed.length(); it++)
        {
            chars[it] = compressed.charAt(it);
        }
        return compressed.length();
    }
}