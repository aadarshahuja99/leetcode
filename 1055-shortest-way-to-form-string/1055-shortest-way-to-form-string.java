class Solution {
    public int shortestWay(String source, String target) {
        int n = source.length();
        int[][] hash = new int[n+1][26];
        Arrays.fill(hash[n], -1);
        for(int i=n-2; i>=-1; i--)
        {
            int nextIndex = source.charAt(i+1) - 'a';
            for(int j=0; j<26; j++)
            {
                hash[i+1][j] = hash[i+2][j];
            }
            hash[i+1][nextIndex] = i+2;
            // System.out.println(i+1);
            // for(int j=0; j<26; j++)
            // {
            //     System.out.print(hash[i+1][j]+" ");
            // }
            // System.out.println();
        }
        int ti = 0;
        int nt = target.length();
        int count = 0;
        while(ti < nt)
        {
            int si = 0;
            int firstIdx = target.charAt(ti) - 'a';
            if(hash[si][firstIdx] == -1)
            {
                return -1;
            }
            while(si < n)
            {
                // System.out.println(ti+" "+si);
                int idx = target.charAt(ti) - 'a';
                if(hash[si][idx] == -1)
                {
                    break;
                }
                si = hash[si][idx];
                ti++;
                if(ti == nt)
                {
                    return count+1;
                }
            }
            count++;
        }
        return count;
    }
}