// MEMOIZATION WILL GIVE TLE (79/80)
class Solution {
    int [] dp;
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        dp=new int [n];
        Arrays.fill(dp,-1);
        int [] prefix=new int [n];
        prefix[0]=stones[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+stones[i];
        }
        return Alice(1,n,prefix);
    }
    public int Alice(int i, int n, int [] prefix){
      if(i==n-1)
      return prefix[n-1];
      if(dp[i]!=-1)
      return dp[i];
      int take=prefix[i]-Alice(i+1,n,prefix);
      int skip=Alice(i+1,n,prefix);
      return dp[i]=Math.max(take,skip);
    }
}

// TABULATION
class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // dp[i] = best score difference starting at index i
        int dp = prefix[n - 1]; // base case
        for (int i = n - 2; i >= 1; i--) {
            dp = Math.max(dp, prefix[i] - dp);
        }
        return dp;
    }
}
