/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}
    public Node(boolean _val, boolean _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    private Node helper(int[][] grid, int r1, int c1, int r2, int c2) {
        // Base Case: If the grid segment contains completely uniform values
        if (isUniform(grid, r1, c1, r2, c2)) {
            return new Node(grid[r1][c1] == 1, true);
        }

        // Divide phase: Calculate coordinate midpoints
        int midRow = r1 + (r2 - r1) / 2;
        int midCol = c1 + (c2 - c1) / 2;

        // Conquer phase: Construct internal node and recurse into 4 quadrants
        Node root = new Node(false, false);
        
        root.topLeft = helper(grid, r1, c1, midRow, midCol);
        root.topRight = helper(grid, r1, midCol + 1, midRow, c2);
        root.bottomLeft = helper(grid, midRow + 1, c1, r2, midCol);
        root.bottomRight = helper(grid, midRow + 1, midCol + 1, r2, c2);

        return root;
    }

    // Helper method to check if all values within the window match
    private boolean isUniform(int[][] grid, int r1, int c1, int r2, int c2) {
        int initialValue = grid[r1][c1];
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] != initialValue) {
                    return false;
                }
            }
        }
        return true;
    }
}
