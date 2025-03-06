class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n*n;
        int totalXor = 0;
        for(int i=1; i<=total; i++)
        {
            totalXor = (totalXor^i);
        }
        int currentXor = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                currentXor = (currentXor^(grid[i][j]));
            }
        }
        int diff = currentXor^totalXor;
        int rightMostSetBitMask = (diff&(-diff));
        int xor1 = 0, xor2 = 0;
        for(int i=1; i<=total; i++)
        {
            if((rightMostSetBitMask&i) > 0)
            {
                xor1 = (xor1^i);
            }
            else
            {
                xor2 = (xor2^i);
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                int val = grid[i][j];
                if((rightMostSetBitMask&val) > 0)
                {
                    xor1 = (xor1^val);
                }
                else
                {
                    xor2 = (xor2^val);
                }
            }
        }
        boolean isXor1Repeating = false;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == xor1)
                {
                    isXor1Repeating = true;
                    break;
                }
            }
        }
        if(isXor1Repeating)
        {
            return new int[] { xor1, xor2 };
        }
        return new int[] { xor2, xor1 };
    }
}