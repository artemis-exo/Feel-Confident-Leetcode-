// // ** MEMOIZATION
// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n=s.length();
//         int m=p.length();
//         int [][] dp=new int[n+1][m+1];
//         for(int i[]:dp){
//             Arrays.fill(i,-1);
//         }
//         return WildCard(s,p,n,m,dp);
//     }
//     public boolean WildCard(String s, String p, int i, int j, int [][] dp){
//          if(i==0 && j==0)return true;
//          if(i>0 && j==0) return false;
//          if(i==0 && j>0){
//             for(int k=0; k<j;k++){
//                 if(p.charAt(k)!='*')
//                 return false;
//             }
//             return true;
//          }
//         if(dp[i][j]!=-1)return dp[i][j]==1;

//         boolean match;
//         if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
//            match= WildCard(s,p,i-1,j-1,dp);
//         }
//         else if(p.charAt(j-1)=='*'){
//             match=WildCard(s,p,i,j-1,dp) || WildCard(s,p,i-1,j,dp);
//         }
//         else{
//             match=false;
//         }
//         dp[i][j]=match?1:0;
//         return match;
//     }
// }
// ** TABULATION
class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean [][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1; i<=n;i++){
            dp[i][0]=false;
        }
        for(int j=1; j<=m;j++){
            boolean flag=true;
            for(int k=0; k<j;k++){
                if(p.charAt(k)!='*'){
                    flag=false;
                    break;
                }
            }
             dp[0][j]=flag;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m;j++){
            if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
             dp[i][j]=dp[i-1][j-1];
            }
            else if(p.charAt(j-1)=='*'){
            dp[i][j]=dp[i][j-1] || dp[i-1][j];
            }
           else{
            dp[i][j]=false;
            }
            }
        }
        return dp[n][m];
    }
}