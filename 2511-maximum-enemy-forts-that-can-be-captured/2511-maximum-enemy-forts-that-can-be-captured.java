class Solution {
    public int captureForts(int[] forts) {
        int ans = 0;
        for(int i=0; i<forts.length; i++)
        {
            if(forts[i] == 1)
            {
                int left = 0;
                int j=i-1;
                while(j >= 0 && forts[j] == 0)
                {
                    j--;
                }
                if(j != -1 && forts[j] == -1)
                {
                    left = i-j-1;
                }
                int right = 0;
                j=i+1;
                while(j < forts.length && forts[j] == 0)
                {
                    j++;
                }
                if(j != forts.length && forts[j] == -1)
                {
                    right = j-i-1;
                }
                ans = Math.max(ans, Math.max(left,right));
            }
        }
        return ans;
    }
}