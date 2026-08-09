// ** Simple MINI-MAX with MEMOIZATION
class Solution {
    int n;
    int dp[][][];
    public int stoneGameII(int[] piles) {
       n=piles.length;
       dp=new int[2][n][n+1];
       for(int i[][]:dp){
        for(int it[]:i){
            Arrays.fill(it,-1);
        }
       }
       return AliceForWin(1,0,1,piles); 
    }
    public int  AliceForWin(int person, int i, int M,int []piles){
        if(i>=n){
            return 0;
        }
        if(dp[person][i][M]!=-1){
            return dp[person][i][M];
        }
        int stones=0;
        int res=person==1?-1:Integer.MAX_VALUE;
        for(int x=1;x<=Math.min(2*M,n-i);x++){ // out of bound choices ke liye safe clamp min
            stones+=piles[i+x-1]; // stone pick karenge  --> -1(0 based indexing)
            if(person==1){
                res=Math.max(res,stones+AliceForWin(0,i+x,Math.max(M,x),piles));
            }
            else{
                res=Math.min(res,AliceForWin(1,i+x,Math.max(M,x),piles)); // suppose iske x=1 se 15 aya Alice ka aur x=2 se 10 aya toh yeh 10 lega taki alice ke stone minimize ho (optimal play)
            }
        }
        return dp[person][i][M]=res;
    }
}
