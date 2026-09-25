class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n=s1.length();
        int m=s2.length();
        int p=s3.length();
        if(p<m+n){
            return false;
        }
        Boolean dp[][][]=new Boolean[n+1][m+1][p+1];
        return Inter(0,0,0,s1,s2,s3,dp);
    }
    public boolean Inter(int i, int j, int k, String s1 , String s2, String s3, Boolean dp[][][]){
        if(i==s1.length() && j==s2.length() && k==s3.length()){
            return true;
        }
        if(k>=s3.length()){
            return false;
        }
        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }
        boolean ans=false;
        if(i < s1.length() && s1.charAt(i)==s3.charAt(k)){
            ans=Inter(i+1,j,k+1,s1,s2,s3,dp);
        }
          if(ans){
            return dp[i][j][k]=ans;
          }
         if(j< s2.length() && s2.charAt(j)==s3.charAt(k)){
            ans=Inter(i,j+1,k+1,s1,s2,s3,dp);
        }
        return dp[i][j][k]=ans;

    }
}