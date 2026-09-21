class Solution {
    Boolean dp[][];
    public String longestPalindrome(String s) {
        int n=s.length();
        dp=new Boolean[n][n];
        int start=0, max=-1;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length();j++){
                if(Palindrome(i,j,s)){
                    if(j-i+1>max){
                        max=j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+max);
    }
    public boolean Palindrome(int i, int j, String s){
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(i>=j)
        return dp[i][j]= true;
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]= Palindrome(i+1,j-1,s);
        }
        return dp[i][j]=false;
    }
}