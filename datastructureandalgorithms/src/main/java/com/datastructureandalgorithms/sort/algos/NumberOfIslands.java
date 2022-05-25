package coding.problems;

/*
 * Dynamic Programming
 * Recursion
 * https://leetcode.com/problems/number-of-islands/solution/
 * https://www.geeksforgeeks.org/find-number-of-islands/
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands nIslands = new NumberOfIslands();
        char[][] grid4x5 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        //Result: 3

        char[][] grid5x5 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '1'}};
        //Result: 8
        System.out.println("Number of islands: " + nIslands.numIslands(grid4x5));
        System.out.println("Number of islands: " + nIslands.numIslands(grid5x5));
    }

    // Get coordinates
    // Mark a visited as '0'
    // Recursively traverse each adjacent item in the grid
    // Update numberOfIslands when we hit '1'
    // Remember beginning of island
    // row/r, column/c is beginning of grid
    public void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        // Base case
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';    // Mark visited as '0'
        dfs(grid, r - '1', c);
        dfs(grid, r + '1', c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numOfIslands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++numOfIslands;
                    dfs(grid, r, c);
                }
            }
        }

        return numOfIslands;
    }

}
