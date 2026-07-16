class Solution {
    int [][][] dp;
    int MOD=1000000007;
    public int subsequencePairCount(int[] nums) {
        int n=nums.length;
        dp=new int [n][201][201];
        for(int i[][]:dp){
            for(int k[]:i){
                Arrays.fill(k,-1);
            }
        }
        return seq(nums,0,0,0);
    }
    public int seq(int [] nums, int idx, int first, int second){
        if(idx==nums.length){
            boolean NonEmpty=(first!=0 && second!=0);
            boolean SameGCD=(first==second);
            return (NonEmpty && SameGCD)?1:0;
        }
        if(dp[idx][first][second]!=-1){
            return dp[idx][first][second];
        }
        int skip=seq(nums,idx+1,first,second);
        int seq1=seq(nums,idx+1,gcd(first,nums[idx]),second);
        int seq2=seq(nums,idx+1,first,gcd(second,nums[idx]));

        return dp[idx][first][second]=(int)((0L+skip+seq1+seq2)%MOD);
    }
    public int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}