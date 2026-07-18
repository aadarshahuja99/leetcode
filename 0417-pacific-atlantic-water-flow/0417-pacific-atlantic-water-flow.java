import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return ans;
        }

        int m = heights.length;
        int n = heights[0].length;
        
        // vis[r][c][0] for Pacific, vis[r][c][1] for Atlantic
        boolean[][][] vis = new boolean[m][n][2];
        Queue<int[]> q = new LinkedList<>();

        // 1. Queue Pacific (top) and Atlantic (bottom) horizontal borders
        for (int j = 0; j < n; j++) {
            // Pacific: top row
            q.add(new int[] { heights[0][j], 0, j, 0 });
            vis[0][j][0] = true;
            
            // Atlantic: bottom row
            q.add(new int[] { heights[m - 1][j], m - 1, j, 1 });
            vis[m - 1][j][1] = true;
        }

        // 2. Queue Pacific (left) and Atlantic (right) vertical borders
        for (int i = 0; i < m; i++) {
            // Pacific: left column
            if (!vis[i][0][0]) {
                q.add(new int[] { heights[i][0], i, 0, 0 });
                vis[i][0][0] = true;
            }
            // Atlantic: right column
            if (!vis[i][n - 1][1]) {
                q.add(new int[] { heights[i][n - 1], i, n - 1, 1 });
                vis[i][n - 1][1] = true;
            }
        }

        int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // 3. Standard Multi-source BFS (Going Uphill)
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int val = top[0];
            int r = top[1];
            int c = top[2];
            int isPacific = top[3];

            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (heights[nr][nc] >= val && !vis[nr][nc][isPacific]) {
                    vis[nr][nc][isPacific] = true;
                    q.add(new int[] { heights[nr][nc], nr, nc, isPacific });
                }
            }
        }

        // 4. Find all cells visited by BOTH oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j][0] && vis[i][j][1]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}
