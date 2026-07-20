class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>>res=new ArrayList<>();
        int n=grid.length;
        int m=grid[0].length;
        k=k%(n*m);
        int x=n*m;
        if(k>0) {
            rev(grid,m,0,x-1);
            rev(grid,m,0,k-1);
            rev(grid,m,k,x-1);
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
    public void rev(int grid[][], int col, int i, int j){
        while(i<j){
            int temp=grid[i/col][i%col];
            grid[i/col][i%col]=grid[j/col][j%col];
            grid[j/col][j%col]=temp;
            i++;
            j--;
        }
    }
}