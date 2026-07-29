// ** MEMOIZATION
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        LCS(0,0,str1,str2,dp);
        return build(str1,str2,dp);
    }
    public int LCS(int i, int j, String s1, String s2, int dp[][]){
        if(i==s1.length() || j==s2.length())return dp[i][j]=0;  //// FIX: Store 0 in the DP table so the build function can read it --->  Because the table was initialized with -1, the boundary edges remain -1.
        if(dp[i][j]!=-1)return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+LCS(i+1,j+1,s1,s2,dp);
        }
        return dp[i][j]=Math.max(LCS(i+1,j,s1,s2,dp),LCS(i,j+1,s1,s2,dp));  // dp Table fill
    }
    public String build(String s, String t, int dp[][]){
        int i=0, j=0;
        StringBuilder sb=new StringBuilder();
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
               sb.append(t.charAt(j));
               i++;
               j++;
            }
                else if(dp[i+1][j]>dp[i][j+1]){
                    sb.append(s.charAt(i));
                    i++;
                }
                else{
                     sb.append(t.charAt(j));
                     j++;
                }
        }
        while(i<s.length()){
            sb.append(s.charAt(i));
            i++;
        }
         while(j<t.length()){
            sb.append(t.charAt(j));
            j++;
        }
        return sb.toString();
    }
}
