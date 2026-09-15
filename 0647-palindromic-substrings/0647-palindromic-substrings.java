class Solution {
    // ---- >> Palindromic Blue Print
    public int countSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        boolean dp[][]=new boolean[n][n];
        for(int L=1; L<=n; L++){
            for(int i=0;i+L-1<n;i++){
               int j=i+L-1;
                if(i==j){
                    dp[i][j]=true;
                }
                else if(i==j-1){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
                }
                if(dp[i][j]==true){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}