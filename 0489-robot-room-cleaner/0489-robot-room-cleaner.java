/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        HashSet<String> seen = new HashSet<>();
        dfs(0,0,0,robot,seen);
    }
    private void dfs(int row, int col, int faceDirection, Robot robot, HashSet<String> vis)
    {
        vis.add(row+" "+col);
        robot.clean();
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        for(int i=0; i<4; i++)
        {
            int newDirection = (faceDirection+i)%4;
            int newRow = row + dirs[newDirection][0];
            int newCol = col + dirs[newDirection][1];
            if(!vis.contains(newRow+" "+newCol) && robot.move())
            {
                dfs(newRow,newCol,newDirection,robot,vis);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}