import java.util.*;

class Solution {
    public int minimumMoves(int[][] grid) {
        int[] start = new int[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                start[i * 3 + j] = grid[i][j];
            }
        }
        
        int[] target = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(Arrays.toString(start));
        
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                if (Arrays.equals(curr, target)) {
                    return moves;
                }
                
                for (int j = 0; j < 9; j++) {
                    if (curr[j] > 1) {
                        // Try to move to adjacent cells
                        for (int next : getAdjacent(j)) {
                            int[] newState = curr.clone();
                            newState[j]--;
                            newState[next]++;
                            if (!visited.contains(Arrays.toString(newState))) {
                                visited.add(Arrays.toString(newState));
                                queue.offer(newState);
                            }
                        }
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
    
     private List<Integer> getAdjacent(int index) {
        List<Integer> adjacent = new ArrayList<>();
        
        int row = index / 3;
        int col = index % 3;
        
        if (col > 0) adjacent.add(index - 1);  // Left
        if (col < 2) adjacent.add(index + 1);  // Right
        if (row > 0) adjacent.add(index - 3);  // Up
        if (row < 2) adjacent.add(index + 3);  // Down
        
        return adjacent;
    }
}
