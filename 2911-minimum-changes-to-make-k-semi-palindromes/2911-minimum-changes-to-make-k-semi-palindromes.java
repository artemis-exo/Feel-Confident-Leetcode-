class Solution {
    int n;
    String st;
    int dp[][];
    int costDp[][];
    public int minimumChanges(String s, int k) {
        n=s.length();
        st=s;
        costDp=new int[n+1][n+1];
        for(int i[]:costDp){
            Arrays.fill(i,-1);
        }
        dp=new int [n+1][k+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return Kpieces(0,k);
    }
    public int Kpieces(int start, int k){
      if(k==0){
        if(start==n){
            return 0;
        }
        return Integer.MAX_VALUE;
      }
      // early return
      if(start+2*k>n){
         return Integer.MAX_VALUE;
      }

      if(dp[start][k]!=-1){
        return dp[start][k];
      }
      int res=Integer.MAX_VALUE;
      for(int end=start+1; end<n; end++){
        // start se --- >> end tak --- > 1 Piece
        int remainingCost=Kpieces(end+1,k-1);
        // invalid case
        if(remainingCost==Integer.MAX_VALUE){
            continue;
        }
        res=Math.min(res,Cost(start,end)+remainingCost); 
      }
      return dp[start][k] =res;
    }
    public int Cost(int i, int j){
        int length=j-i+1;
        if(costDp[i][j]!=-1){
            return costDp[i][j];
        }
        int minCos=Integer.MAX_VALUE;

        for(int div=1;div<length; div++){
            if(length%div!=0){
                continue;
            }
            int cost=0;
            for(int group=0;group<div;group++){ // jitni D ki values utne d groups
               int l=i+group;
               int r=l+(length/div-1)*div;

               while(l<r){
                if(st.charAt(l)!=st.charAt(r)){
                    cost++;
                }
                l=l+div;
                r=r-div;
               }
            }
            minCos=Math.min(minCos,cost);
        }
        return costDp[i][j] =minCos;
    }
}