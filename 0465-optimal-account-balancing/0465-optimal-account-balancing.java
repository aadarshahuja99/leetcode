class Solution {
    public int minTransfers(int[][] transactions) {
        // Recursion + backtracking (try all possible next people to transfer the debt to)
        int[] debt = new int[12];
        for(int[] transaction : transactions)
        {
            debt[transaction[0]] -= transaction[2];
            debt[transaction[1]] += transaction[2];
        }
        return getAns(0, debt);
    }
    private int getAns(int current, int[] debt)
    {
        while(current < debt.length && debt[current] == 0)
        {
            current++;
        }
        if(current == debt.length)
        {
            return 0;
        }
        int txns = Integer.MAX_VALUE;
        for(int i = current+1; i<debt.length; i++)
        {
            if(debt[i]*debt[current] < 0)
            {
                // a valid candidate
                debt[i] += debt[current];
                txns = Math.min(txns, 1 + getAns(current+1, debt));
                debt[i] -= debt[current];
            }
        }
        return txns;
    }
}