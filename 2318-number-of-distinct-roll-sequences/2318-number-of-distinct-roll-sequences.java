class Solution {
    ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
    int MOD = 1_000_000_007;
    public int distinctSequences(int n) {
        int[][][] cache = new int[n][7][7];
        for(int[][] nr : cache)
        {
            for(int[] row : nr)
            {
                Arrays.fill(row, -1);
            }
        }
        for(int i=0; i<=6; i++)
        {
            moves.add(new ArrayList<>());
        }
        moves.get(1).add(2);
        moves.get(1).add(3);
        moves.get(1).add(4);
        moves.get(1).add(5);
        moves.get(1).add(6);
        
        moves.get(2).add(3);
        moves.get(2).add(1);
        moves.get(2).add(5);

        moves.get(3).add(1);
        moves.get(3).add(5);
        moves.get(3).add(2);
        moves.get(3).add(4);

        moves.get(4).add(1);
        moves.get(4).add(3);
        moves.get(4).add(5);

        moves.get(5).add(1);
        moves.get(5).add(2);
        moves.get(5).add(3);
        moves.get(5).add(4);
        moves.get(5).add(6);

        moves.get(6).add(1);
        moves.get(6).add(5);

        return getAns(0, 0, 0, n, cache);
    }
    private int getAns(int current, int last, int lastToLast, int n, int[][][] cache)
    {
        if(current == n)
        {
            return 1;
        }
        if(cache[current][last][lastToLast] != -1)
        {
            return cache[current][last][lastToLast];
        }
        int ans = 0;
        if(last == 0)
        {
            for(int i=1; i<=6; i++)
            {
                ans = (ans%MOD + getAns(current+1, i, last, n, cache)%MOD)%MOD;
            }
        }
        else
        {
            for(int next : moves.get(last))
            {
                if(next == last || next == lastToLast)
                {
                    continue;
                }
                ans = (ans%MOD + getAns(current+1, next, last, n, cache)%MOD)%MOD;
            }
        }
        return cache[current][last][lastToLast] = ans;
    }
}