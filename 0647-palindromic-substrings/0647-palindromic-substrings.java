// DP MEMOIZATION --- Every subproblem is being computed
class Solution {
    // ---- >> Palindromic Blue Print
    public int countSubstrings(String s) {
        int n=s.length();
        int dp[][]=new int [n+1][n+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int cnt=0;
        for(int i=0; i<n;i++){
            for(int j=i; j<n; j++){
                if(Check(i,j,dp,s)){
                    cnt++;
                }
            }
        }
       return cnt;
    }
    public boolean Check(int i, int j, int [][] dp, String s){
        if(i>=j){
            return true;
        }
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        if(s.charAt(i)==s.charAt(j)){
            boolean val=Check(i+1,j-1,dp,s);
            if(val){
                dp[i][j]=1;
            }
            else{
                dp[i][j]=0;
            }
            return val;
        }
        dp[i][j]=0;
        return false;
    }
}



// class Solution {
//     // ---- >> Palindromic Blue Print
//     public int countSubstrings(String s) {
//         int n=s.length();
//         int cnt=0;
//         boolean dp[][]=new boolean[n][n];
//         for(int L=1; L<=n; L++){
//             for(int i=0;i+L-1<n;i++){
//                int j=i+L-1;
//                 if(i==j){
//                     dp[i][j]=true;
//                 }
//                 else if(i==j-1){
//                     dp[i][j]=(s.charAt(i)==s.charAt(j));
//                 }
//                 else{
//                     dp[i][j]=(s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
//                 }
//                 if(dp[i][j]==true){
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// }