class Solution {
         int n;
        int col;
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>>res=new ArrayList<>();
        n=grid.length;
        col=grid[0].length;
        k=k%(n*col);
        int x=n*col;
        if(k>0) {
            rev(grid,0,x-1);
            rev(grid,0,k-1);
            rev(grid,k,x-1);
        }
        for(int i[]:grid){
            List<Integer>li=new ArrayList<>();
            for(int g:i){
                li.add(g);
            }
            res.add(li);
        }
        return res; 
    }
    public void rev(int grid[][], int i, int j){
        while(i<j){
            int temp=grid[i/col][i%col];
            grid[i/col][i%col]=grid[j/col][j%col];
            grid[j/col][j%col]=temp;
            i++;
            j--;
        }
    }
}