class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int i=0; i<rows; i++)
        {
            int[] current = new int[cols];
            int[] flipped = new int[cols];
            for(int j=0; j<cols; j++)
            {
                current[j] = matrix[i][j];
                flipped[j] = matrix[i][j] == 1 ? 0 : 1;
            }
            int currentHashCode = Arrays.hashCode(current);
            int flippedHashCode = Arrays.hashCode(flipped);
            int currentMax = counts.getOrDefault(currentHashCode, 0) + counts.getOrDefault(flippedHashCode, 0) + 1;
            ans = Math.max(ans, currentMax);
            counts.put(currentHashCode, counts.getOrDefault(currentHashCode, 0) + 1);
        }
        return ans;
    }
}