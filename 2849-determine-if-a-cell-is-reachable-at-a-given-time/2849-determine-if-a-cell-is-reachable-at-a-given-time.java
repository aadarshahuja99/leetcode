class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // initial thought was correct: find the min time to get to the destination cell
        // if min time >= t, then return true.
        // the key trick here is that the min time to get to dest from source is:
        // Math.max(heightDiff, widthDiff) -> reduces the problem to O(1) without the need for DFS
        int minTime = Math.max(Math.abs(fx - sx), Math.abs(fy - sy));
        if(minTime == 0 && t == 1)
        {
            return false;
        }
        return minTime <= t;
    }
}