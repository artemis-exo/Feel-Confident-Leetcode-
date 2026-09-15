// ----- >> Using Dp MEMOIZATION
class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        if(k==1){
            return n; // humko max number palindrome niklana hai tohagr k =1 hoga toh sare hi palindrome hoonge 
        }
        int dp[][]=new int[n][n];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        return MaxPalin(0,k-1,s,k,dp);
    }
    public int MaxPalin(int i, int j, String s,int k, int [][] dp){
        if(i>=s.length() || j>=s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(IsPalindrome(s,i,j)){
            int pick=1+MaxPalin(j+1,j+k,s,k,dp);
            int slider=MaxPalin(i+1,j+1,s,k,dp);
            int increase=MaxPalin(i,j+1,s,k,dp);
            return dp[i][j]=Math.max(pick,Math.max(slider, increase));
        }
        int slider=MaxPalin(i+1,j+1,s,k,dp);
        int increase=MaxPalin(i,j+1,s,k,dp);

        return dp[i][j]=Math.max(slider, increase);
    }
    public boolean IsPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}