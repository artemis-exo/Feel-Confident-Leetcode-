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

// *** TABULATION
class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        if(k==1){
            return n;
        }
        int [][] dp=new int [n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int j=n-1;j>=0;j--){
                if(IsPalindrome(s,i,j)){
                    int take=1+(j+k<=n?dp[j+1][j+k]:0);
                    int slider=dp[i+1][j+1];
                    int increase=dp[i][j+1];

                    dp[i][j]=Math.max(take,Math.max(slider,increase));
                }
                int slider=dp[i+1][j+1];
                int increase=dp[i][j+1];
                dp[i][j]=Math.max(dp[i][j],Math.max(slider,increase));
            }
        }
        return dp[0][k-1];
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


// ----- >> Using Dp MEMOIZATION USing Blueprint for reducing n3 TC
class Solution {
    boolean [][]pd;
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        if(k==1){
            return n; // humko max number palindrome niklana hai tohagr k =1 hoga toh sare hi palindrome hoonge 
        }
         pd=new boolean[n][n];
        for(int L=1; L<=n;L++){
            for(int i=0; i+L-1<n;i++){
                int j=i+L-1;
                if(i==j){
                    pd[i][j]=true;
                }
                else if(i==j-1){
                    pd[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else{
                     pd[i][j]=(s.charAt(i)==s.charAt(j)) && pd[i+1][j-1];
                }
            }
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
        if(pd[i][j]){
            int pick=1+MaxPalin(j+1,j+k,s,k,dp);
            int slider=MaxPalin(i+1,j+1,s,k,dp);
            int increase=MaxPalin(i,j+1,s,k,dp);
            return dp[i][j]=Math.max(pick,Math.max(slider, increase));
        }
        int slider=MaxPalin(i+1,j+1,s,k,dp);
        int increase=MaxPalin(i,j+1,s,k,dp);

        return dp[i][j]=Math.max(slider, increase);
    }
    
}

