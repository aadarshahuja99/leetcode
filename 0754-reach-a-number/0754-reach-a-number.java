class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        // if there is an even difference between current sum and target, we need to reverse the sign of the number: (diff/2), this will reduce the difference by diff
        // else if, diff is odd, add 'k+1' to the diff, if k+1 is also odd, we have the answer as k+1. Else we need to add k+2, which will be odd to the existing odd difference till summation of k+1, and thus our answer will be k+2.
        return target % 2 == 0 ? k : k + 1 + k%2;
    }
}