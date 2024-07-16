class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        Arrays.sort(quantities);
        long totalProducts = 0;
        int numberOfProducts = quantities.length;
        for(int i=0; i<numberOfProducts; i++)
        {
            totalProducts += 1L*quantities[i];
        }
        long start = 1;
        long end  = totalProducts;
        long ans = -1;
        // System.out.println(quantities.length + " ");
        while(start <= end)
        {
            long mid = start + (end-start)/2; 
            if(check(mid, quantities, n, numberOfProducts))
            {
                end = mid-1;
                ans = mid;
            }
            else
            {
                start = mid+1;
            }
        }
        return (int)ans;
    }
    private boolean check(long guess, int[] quantities, int n, int numberOfProducts)
    {
        long numberOfStoresNeeded = 0;
        for(int i=0; i<numberOfProducts; i++)
        {
            numberOfStoresNeeded += (long)Math.ceil((double)quantities[i]/guess);
        }
        // System.out.println(guess+" "+(numberOfStoresNeeded <= n));
        return numberOfStoresNeeded <= n;
    }
}