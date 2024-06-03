class Solution {
    // kansal sir's method
    public int appendCharacters(String s, String t) {
        int[][] hash = new int[s.length()+1][26];
        int n = s.length();
        Arrays.fill(hash[n], -1);
        for(int i=n-2; i>=-1; i--)
        {
            char c = s.charAt(i+1);
            int currentAlphabet = c - 'a';
            for(int j=0; j<26; j++)
            {
                hash[i+1][j] = hash[i+2][j];
            }
            hash[i+1][currentAlphabet] = i+1;
        }
        // for(int i=0; i<=n; i++)
        // {
        //     for(int j=0; j<26; j++)
        //     {
        //         System.out.print(hash[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int current = 0;
        int length = 0;
        for(char c : t.toCharArray())
        {
            int alphabetIndex = c - 'a';
            if(hash[current][alphabetIndex] == -1)
            {
                break;
            }
            current = hash[current][alphabetIndex] + 1;
            length++;
        }
        return t.length() - length;
    }
}