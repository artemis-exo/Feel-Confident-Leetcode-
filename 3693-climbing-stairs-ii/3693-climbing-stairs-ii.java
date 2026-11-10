// // Java MEMOIZATION
// class Solution {
//     public int climbStairs(int n, int[] costs) {
//         int [] dp=new int[n+1];
//         Arrays.fill(dp,-1);
//         return Stairs(0,n,costs,dp);
//     }
//     public int Stairs(int i, int n, int [] costs, int [] dp){
//         if(i==n){
//             return 0;
//         }
//         if(dp[i]!=-1){
//             return dp[i];
//         }
//         int one=(costs[i]+1)+Stairs(i+1,n,costs,dp);  // costs[j] + (j - i)2 --- > Dervied from observation
//         int two=Integer.MAX_VALUE;
//         if(i+2<=n){
//             two=(costs[i+1]+4)+Stairs(i+2,n,costs,dp);
//         }
//         int three=Integer.MAX_VALUE;
//         if(i+3<=n){
//             three=(costs[i+2]+9)+Stairs(i+3,n,costs,dp);
//         }
//         dp[i]=Math.min(one,Math.min(two,three));
//         return dp[i];

//     }
// }


// TABULATION
class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        // Base case
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int one = (costs[i] + 1) + dp[i + 1];

            int two = Integer.MAX_VALUE;
            if (i + 2 <= n) {
                two = (costs[i + 1] + 4) + dp[i + 2];
            }
            int three = Integer.MAX_VALUE;
            if (i + 3 <= n) {
                three = (costs[i + 2] + 9) + dp[i + 3];
            }
            dp[i] = Math.min(one, Math.min(two, three));
        }
        return dp[0];
    }
}