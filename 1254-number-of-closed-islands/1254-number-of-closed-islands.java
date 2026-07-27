class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int closed=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0){
                    if(dfs(i,j,grid)){
                        closed++; // true ayega mtlb closed island possible hai
                    }
                }
            }
        }
        return closed;
    }
    public boolean dfs(int i, int j, int[][] grid){
        if(i<0 || j<0 || j>=grid[0].length || i>=grid.length){ // yeh boundry case handle karega
            return false;
        }
        if(grid[i][j]==1){
            return true;
        }
        grid[i][j]=1; // visist mark krne ka tareeka
        boolean up=dfs(i-1,j,grid);
        boolean down=dfs(i+1,j,grid);
        boolean left=dfs(i,j-1,grid);
        boolean right=dfs(i,j+1,grid);

        return up && down && left && right; // sari calls intial idx ex(1,1) pe wapas ayengni toh yeh true ya false ka decision lega
    }
}