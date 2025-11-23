class Solution {
    public int numDistinctIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Set<String> set = new HashSet<>();

        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, grid, vis, sb, '0');
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public void dfs(int r, int c, int[][] grid, boolean[][] vis, StringBuilder sb, char ch){
        int row = grid.length;
        int col = grid[0].length;

        if(r >= 0 && r < row && c >= 0 && c < col 
        && !vis[r][c] && grid[r][c] == 1){
            vis[r][c] = true;
            sb.append(ch);
            dfs(r - 1, c, grid, vis, sb, 'u');
            dfs(r + 1, c, grid, vis, sb, 'd');
            dfs(r, c - 1, grid, vis, sb, 'l');
            dfs(r, c + 1, grid, vis, sb, 'r');
            sb.append('0');
        }
    }
}