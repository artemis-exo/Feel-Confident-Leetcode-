// --- >> ** MEMOIZATION -- >> pick not pick and simply loop over for end points

/// This is Giving TLE
// class Solution {
//     int MOD=(int)1e9+7;
//     int dp[][];
//     public int numberOfSets(int n, int k) {
//         dp=new int[n+1][k+1];
//         for(int i[]:dp){
//             Arrays.fill(i,-1);
//         }
//         return Lines(n,k,0)%MOD;
//     }
//     public int Lines(int n, int k, int i){
//         if(k==0){
//             return 1;
//         }
//         if(i>=n){
//             return 0;
//         }
//         if(dp[i][k]!=-1){
//             return dp[i][k];
//         }
//         long pick=0;
//         for(int j=i+1;j<n;j++){  // end points loop
//             pick=(pick+Lines(n,k-1,j))%MOD;
//         }
//         long notPick=Lines(n,k,i+1);
//         return dp[i][k]=(int)((pick+notPick)%MOD);

//     }
// }

// TABULATION --- TLE DERA HAI 
// class Solution {
//     int MOD=(int)1e9+7;
//     public int numberOfSets(int n, int k) {
//         int [][] dp=new int[n+1][k+1];
//         for(int i=0; i<n;i++){
//             dp[i][0]=1;
//         }
//         for(int i=n-1; i>=0; i--){
//             for(int p=1;p<=k;p++){
//                 int pick=0;
//                 for(int j=i+1;j<=n-1;j++){
//                     pick=(pick+dp[j][p-1])%MOD;
//                 }
//                 int notPick=dp[i+1][p]%MOD;
//                 dp[i][p]=(pick+notPick)%MOD;
//             }
//         }
//         return dp[0][k];
//     }
// }

// OPTIMIZATION USING PRECOMPUTED PREF ARRAY
 // ------ >> Removing j loop

 class Solution {
    int MOD=(int)1e9+7;
    public int numberOfSets(int n, int k) {
        int [][] dp=new int[n+1][k+1];
        int [] pref=new int[k+1];
        for(int i=0; i<n;i++){
            dp[i][0]=1;
        }
        pref[0]=1;
        for(int i=n-2; i>=0; i--){
            for(int p=1;p<=k;p++){
                int pick=0;
                dp[i][p]=(dp[i+1][p]+pref[p-1])%MOD;
                pref[p-1]=(pref[p-1]+dp[i][p-1])%MOD;
            }
            pref[k]=(pref[k]+dp[i][k])%MOD;
        }
        return dp[0][k];
    }
}