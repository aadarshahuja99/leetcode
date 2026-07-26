class Solution {
    /*
     * INTUITION:
     * We want to reduce a number 'n' to 0 using the minimum number of additions or 
     * subtractions of powers of 2. This is highly related to the binary form of 'n'.
     * - Isolated '1' bits (e.g., ...00100...) are best removed by subtracting that power of 2.
     *   Cost: 1 operation.
     * - Consecutive blocks of '1' bits (e.g., ...01110...) can either be subtracted 
     *   one by one (costing 3 operations for three 1s), OR we can ADD 1 at the lowest bit position.
     *   Adding 1 triggers a carry-over chain that turns "...0111..." into "...1000...". 
     *   This clears the entire block of 1s and leaves us with just a single '1' further up, 
     *   which we can later subtract. 
     *   Cost: 1 addition + 1 eventual subtraction = 2 operations total (saving operations!).
     *
     * WHY WE CHECK `(n & 3) == 3`:
     * - `3` in binary is `11`. 
     * - Doing a bitwise AND (`n & 3`) isolates the last two lowest bits of 'n'.
     * - If `(n & 3) == 3`, it means the last two bits are currently `11`.
     * - This signals that we are at the start of a consecutive block of multiple 1s. 
     *   Therefore, it is optimal to ADD 1 to carry over and clear the block.
     * - If the last two bits are NOT `11`, we safely process the lowest bit individually: 
     *   if it's 1, we subtract it; if it's 0, we just shift it away.
     *
     * EXAMPLE WALKTHROUGH (n = 39):
     * 39 in binary is 100111.
     * 
     * Step 1: n = 39 (100111)
     *        n & 3 -> 100111 & 000011 = 11 (3).
     *        Since it equals 3, we ADD 1. 
     *        n becomes 39 + 1 = 40 (101000). ops = 1.
     *
     * Step 2: n = 40 (101000)
     *        n & 3 -> 101000 & 000011 = 00 (0). Not 3.
     *        ops += (40 & 1) -> ops += 0. ops = 1.
     *        Shift right: n = 20 (10100).
     *
     * Step 3: n = 20 (10100)
     *        n & 3 -> 10100 & 00011 = 00 (0). Not 3.
     *        ops += (20 & 1) -> ops += 0. ops = 1.
     *        Shift right: n = 10 (101).
     *
     * Step 4: n = 10 (101)
     *        n & 3 -> 101 & 011 = 01 (1). Not 3.
     *        ops += (10 & 1) -> ops += 0. ops = 1.
     *        Shift right: n = 5 (101).
     *
     * Step 5: n = 5 (101)
     *        n & 3 -> 101 & 011 = 01 (1). Not 3.
     *        ops += (5 & 1) -> ops += 1. ops = 2.
     *        Shift right: n = 2 (10).
     *
     * Step 6: n = 2 (10)
     *        n & 3 -> 10 & 11 = 10 (2). Not 3.
     *        ops += (2 & 1) -> ops += 0. ops = 2.
     *        Shift right: n = 1 (1).
     *
     * Step 7: n = 1 (1)
     *        n & 3 -> 01 & 11 = 01 (1). Not 3.
     *        ops += (1 & 1) -> ops += 1. ops = 3.
     *        Shift right: n = 0. Loop terminates.
     * 
     * Total Operations for 39: 3 (Optimal path: 39 + 1 - 8 - 32 = 0).
     */
    public int minOperations(int n) {
        int operations = 0;
        
        while (n > 0) {
            // Check if the two lowest bits are '11'
            if ((n & 3) == 3) {
                operations++;
                n += 1; // Add 1 to initiate carry-over string reduction
            } else {
                // If lowest bit is 1, we subtract it (ops++). If 0, we do nothing.
                operations += (n & 1);
                // Shift right by 1 to inspect the next bit
                n >>= 1;
            }
        }
        
        return operations;
    }
}
