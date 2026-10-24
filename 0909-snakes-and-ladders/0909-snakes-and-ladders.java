class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int target=n*n;
        int steps[]=new int[target+1];
        Arrays.fill(steps,-1);
        Queue<Integer>pq=new LinkedList<>();
        pq.offer(1); // 1 se start
        steps[1]=0; // intial pe cost 0
        while(!pq.isEmpty()){
            int curr=pq.poll();
            if(curr==target){
                return steps[curr]; // agr n^2 pe raech kar gye toh return krdo min steps ko
            }
            for(int inext=curr+1;inext<=Math.min(target,curr+6);inext++){
                 int corr[]=getCoor(inext,n);
                 int row=corr[0];
                 int col=corr[1];
                 int dest=(board[row][col]!=-1)?board[row][col]:inext; // agr ladder ya snake hai toh uski updated val dal do

                 if(steps[dest]==-1){ // visit nahi hai toh 
                    steps[dest]=steps[curr]+1; // dest pe jane ke liye current cost mey +1
                  pq.offer(dest); // aur queue mey push
                 }
            }
        }
        return -1;
    }
    public int[] getCoor(int i, int n){
        int rowFromBottom=(i-1)/n; // neche se row ki value
        int row=n-rowFromBottom-1; // but coding mey hum top se hi acces kar skte hai top ke point view se bottom vali
        int rem=(i-1)%n; // yeh col nikalne ke liye 
        int col=(rowFromBottom%2==0)?rem:n-1-rem; // Zigzag way mey hai toh if even hai toh wohi rem rahaega nhi toh n-1rem for 0 based indexing

        return new int[]{row,col};
    }
}