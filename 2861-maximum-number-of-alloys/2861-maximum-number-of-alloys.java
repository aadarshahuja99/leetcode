class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int start = 0;
        int end = 100000000;
        int ans = 0;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(check(mid, budget, composition, stock, cost))
            {
                // System.out.println(mid);
                ans = mid;
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }
    private boolean check(int current, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost)
    {
        int idx = 0;
        for(List<Integer> requirements : composition)
        {
            long rem = budget;
            boolean canBeDone = true;
            for(int i=0; i<stock.size(); i++)
            {

                long quantityNeeded = 1l*current*requirements.get(i);
                if(stock.get(i) >= quantityNeeded)
                {
                    continue;
                }
                quantityNeeded -= stock.get(i);
                long currentcost = quantityNeeded*1l*cost.get(i);
                // System.out.println("at idx: " +idx + " currentCost = "+currentcost+" for i: "+i+" q: "+quantityNeeded);
                if(currentcost > rem)
                {
                    canBeDone = false;
                    break;
                }
                rem -= currentcost;
            }
            if(canBeDone)
            {
                // System.out.println();
                // System.out.println(idx+" can make "+current+" with rem: "+rem);
                // System.out.println();
                return true;
            }
            idx++;
        }
        return false;
    }
}