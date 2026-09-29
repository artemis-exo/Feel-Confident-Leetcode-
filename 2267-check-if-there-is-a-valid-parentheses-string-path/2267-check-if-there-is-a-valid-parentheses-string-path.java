class Solution {
    public boolean hasValidPath(char[][] grid) {
         int m = grid.length;
         int n = grid[0].length;
         if ((m + n - 1) % 2 != 0) return false;
         if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
         Boolean[][][] dp = new Boolean[m][n][m + n + 1];
         
         return Valid(0, 0, 0, grid, dp);
    }
    
    public boolean Valid(int i, int j, int cnt, char[][] grid, Boolean[][][] dp) {
        // Valid Boundry checks
        if (i >= grid.length || j >= grid[0].length) {
            return false;
        }
        
        cnt += (grid[i][j] == '(') ? 1 : -1;
        // Agar cnt -1 puch gya toh return krdo false kyu ki ab possible nhi hai
        if (cnt < 0) {
            return false;
        }
        if (dp[i][j][cnt] != null) {
            return dp[i][j][cnt];
        }
        //cnt==0 hua if last mey toh true return 
        if (i == grid.length - 1 && j == grid[0].length - 1) {
             return dp[i][j][cnt] = (cnt == 0);
        }
        boolean down = Valid(i + 1, j, cnt, grid, dp);
        boolean right = Valid(i, j + 1, cnt, grid, dp);
        return dp[i][j][cnt] = (down || right);
    }
}