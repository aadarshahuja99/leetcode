public class Solution {
    public int MctFromLeafValues(int[] arr) {
        int[,] dp = new int[arr.Length,arr.Length];
        for(int i=arr.Length-1; i>=0; i--)
        {
            for(int j=0; j<arr.Length; j++)
            {
                if(i >= j)
                {
                    continue;
                }
                int min = Int32.MaxValue;
                for(int k=i; k<j; k++)
                {
                    int left = getMax(i,k,arr);
                    int right = getMax(k+1,j,arr);
                    min = Math.Min(min, left*right + dp[i,k] + dp[k+1,j]);
                }
                dp[i,j] = min;
            }
        }
        return dp[0,arr.Length-1];
    }
    // public int getMin(int i, int j, int[] arr, int[,] dp)
    // {
    //     // only one node can not lead to partitions
    //     if(i==j)
    //     {
    //         return 0;
    //     }
    //     if(dp[i,j] != -1)
    //     {
    //         return dp[i,j];
    //     }
    //     int min = Int32.MaxValue;
    //     for(int k=i; k<j; k++)
    //     {
    //         int left = getMax(i,k,arr);
    //         int right = getMax(k+1,j,arr);
    //         min = Math.Min(min, left*right + getMin(i,k,arr,dp) + getMin(k+1,j,arr,dp));
    //     }
    //     dp[i,j] = min;
    //     return min;
    // }
    private int getMax(int i, int j, int[] arr)
    {
        int max = -1;
        for(int k=i; k<=j; k++)
        {
            max = Math.Max(max,arr[k]);
        }
        return max;
    }
}