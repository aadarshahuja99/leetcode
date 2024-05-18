class Solution {
    public String getPermutation(int n, int k) {
        // find out the group to which n belongs, then find out the subgroup
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        factorial[1] = 1;
        for(int i=2; i<=n; i++)
        {
            factorial[i] = factorial[i-1]*i;
        }
        int digits = n;
        String ans = "";
        int key = k-1;
        HashSet<Integer> visited = new HashSet<>();
        while(digits > 0)
        {
            int group = key/factorial[digits-1];
            int i=1;
            int j=0;
            while(i <= n && j <= group)
            {
                if(!visited.contains(i))
                {
                    i++;
                    j++;
                }
                else
                {
                    i++;
                }
            }
            ans += (i-1);
            // System.out.println(i+" "+group+" digits: "+digits);
            visited.add(i-1);
            key = key%factorial[digits-1];
            digits--;
        }
        return ans;
    }
}