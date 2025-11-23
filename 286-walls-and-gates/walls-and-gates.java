import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Use the exact constant required by the problem
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    
    // Optimization: Use a 2D array instead of a List for slightly faster access
    private static final int[][] DIRECTIONS = {
        { 1,  0}, {-1,  0}, { 0,  1}, { 0, -1}
    };

    public void wallsAndGates(int[][] rooms) {
        // Robustness: Check for null to prevent NullPointerException
        if (rooms == null || rooms.length == 0) return;
        
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();

        // 1. Initialize the Queue with all Gates (Multi-Source BFS)
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }

        // 2. BFS Execution
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];

            for (int[] dir : DIRECTIONS) {
                int r = row + dir[0];
                int c = col + dir[1];

                // Boundary checks + Check if the cell is EMPTY
                // If it is not EMPTY (meaning it is a Wall or already visited), skip it.
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }

                // Update distance and add to queue
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
}