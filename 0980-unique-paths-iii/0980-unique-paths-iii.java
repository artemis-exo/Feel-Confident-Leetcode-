class Solution {
    public int uniquePathsIII(int[][] grid) {
        /*
        1---- >>  isme mey yeh karunga ki phele Total 0 count krlnga kyu ki question mey mention hai ki sare 0 include krne hai
         2 ---- >> // aur phit 1 wle ke row, col store krke recursion call krdunga
         3 -- >> 4 directional scan krte hue jayenge
         4 ---- >> Aur gird [i][j] =-1 for visited kyu ki ek cell mey ek baar aur zero--;

         5 --- >> Aur jab 1 valid path mil jayega toh zero++ age ke paths ke liye toh grid[i][j]=0 unvisted
        */

        int row=0, col=0, zero=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[i].length; j++){
                if(grid[i][j]==0){
                    zero++;
                }
                else if(grid[i][j]==1){
                   row=i;
                   col=j;
                }
            }
        }
        return UniqueDfs(row,col,grid,zero);
    }
    public int UniqueDfs(int i, int j, int [][] grid, int zero){
        if(i<0 || j< 0|| j>=grid[0].length || i>=grid.length || grid[i][j] == -1){
            return 0;
        }
        if(grid[i][j]==2){
            return zero==-1 ?1:0;
        }
        grid[i][j]=-1;
        zero--;
        int path=UniqueDfs(i+1,j,grid,zero)+UniqueDfs(i-1,j,grid,zero)+UniqueDfs(i,j+1,grid,zero)+UniqueDfs(i,j-1,grid,zero);
        zero++;
        grid[i][j]=0;

        return path;
    }
}