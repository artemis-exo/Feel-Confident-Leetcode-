// // ** MEMOIZATION
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n=text1.length();
//         int m=text2.length();
//         int [][] dp=new int[n][m];
//         for(int i[]:dp){
//             Arrays.fill(i,-1);
//         }
//         return Common(n-1,m-1,text1,text2,dp);
//     }
//     public int Common(int i, int j, String s, String t, int [][]dp){
//         if(i<0 || j<0)
//         return 0;
//         if(dp[i][j]!=-1)
//         return dp[i][j];

//         if(s.charAt(i)==t.charAt(j)){
//             return dp[i][j]=1+Common(i-1,j-1,s,t,dp);
//         }
//         return dp[i][j]=0+Math.max(Common(i-1,j,s,t,dp),Common(i,j-1,s,t,dp));
//     }
// }

// ** TABULATION
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int [][] dp=new int[n+1][m+1];
        for(int i=1; i<=n; i++){
           for(int j=1;j<=m;j++){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
            }
            else{
                dp[i][j]=0+Math.max(dp[i-1][j],dp[i][j-1]);
            }
           }
        }
        return dp[n][m];
    }
}