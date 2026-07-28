class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int [][] dp=new int[n+1][m+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return WildCard(s,p,n,m,dp);
    }
    public boolean WildCard(String s, String p, int i, int j, int [][] dp){
         if(i==0 && j==0)return true;
         if(i>0 && j==0) return false;
         if(i==0 && j>0){
            for(int k=0; k<j;k++){
                if(p.charAt(k)!='*')
                return false;
            }
            return true;
         }
        if(dp[i][j]!=-1)return dp[i][j]==1;

        boolean match;
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
           match= WildCard(s,p,i-1,j-1,dp);
        }
        else if(p.charAt(j-1)=='*'){
            match=WildCard(s,p,i,j-1,dp) || WildCard(s,p,i-1,j,dp);
        }
        else{
            match=false;
        }
        dp[i][j]=match?1:0;
        return match;
    }
}