// // ** MEMOIZATION 
// class Solution {
//     int [] dp;
//     public boolean winnerSquareGame(int n) {
//         dp=new int[n+1];
//         Arrays.fill(dp,-1);
//         return AliceForWin(n);
//     }
//     public boolean AliceForWin(int n){
//         if(n==0)return false;

//         if(dp[n]!=-1)
//         return dp[n]==1?true :false;
//         for(int i=1;i*i<=n;i++){
//             if(AliceForWin(n-(i*i))==false){ // call for Bob // False -- Bob Lost
//                 dp[n]=1;
//                 return true; // Alice Won the game
//             }
//         }
//         dp[n]=0;
//         return false; // Alice could never win
//     }
// }

// ** TABULATION

class Solution {
    public boolean winnerSquareGame(int n) {
           int [] dp=new int[n+1];
           dp[0]=0;
           for(int i=1; i<=n; i++){
            for(int x=1; x*x<=i; x++){
                if(dp[i-(x*x)]==0){
                    dp[i]=1;
                    break;
                }
            }
           }
           return dp[n]==1;
    }
}
