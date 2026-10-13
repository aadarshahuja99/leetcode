class Solution {
// There are only two possibilities to form a non-adjacent row: 3 colors combination (use all three colors, e.g., RYG) and 2 color combination (use only two of three colors, e.g., RYR).
// We add the new row one by one. Apart from its inner adjacent relation, every new added row only relies on the previous one row (new added row is only adjacent with the row above it).
// Every color combination follows the same pattern indicated below. 3-color combination can generate two 3-color combination, and two 2-color combination for the next round. 2-color combination can generate two 3-color combination, and three 2-color combination for the next round.
    int MOD = 1_000_000_007;
    public int numOfWays(int n) {
        long colorCombinationsFor3Pattern = 6;
        long colorCombinationsFor2Pattern = 6;
        for(int i=1; i<n; i++)
        {
            long temp3 = colorCombinationsFor3Pattern;
            colorCombinationsFor3Pattern = ((2*colorCombinationsFor3Pattern)%MOD + 
            (2*colorCombinationsFor2Pattern)%MOD)%MOD;
            colorCombinationsFor2Pattern = ((2*temp3)%MOD + 
            (3*colorCombinationsFor2Pattern)%MOD)%MOD;
        }
        return (int)((colorCombinationsFor3Pattern + colorCombinationsFor2Pattern)%MOD);
    }
}