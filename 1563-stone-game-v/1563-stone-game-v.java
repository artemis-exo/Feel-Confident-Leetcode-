class Solution {
    int [][] dp;
    public int stoneGameV(int[] stoneValue) {
        dp=new int[stoneValue.length][stoneValue.length];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return AliceKiJeet(0, stoneValue.length-1, stoneValue);
    }
    public int AliceKiJeet(int i, int j, int [] stoneValue){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int total=0;
        for(int h=i; h<=j;h++){
            total+=stoneValue[h];
        }
        int left=0, right=0;
        int res=0;
        for(int h=i;h<stoneValue.length;h++){
            left+=stoneValue[h];
            right=total-left;

            if(left<right){
                res=Math.max(res,left+AliceKiJeet(i,h,stoneValue));
            }
            else if(right<left){
                res=Math.max(res,right+AliceKiJeet(h+1,j,stoneValue));
            }
            else{
                res=Math.max(res,right+Math.max(AliceKiJeet(i,h,stoneValue),AliceKiJeet(h+1,j,stoneValue)));
            }
        }
        return dp[i][j]=res;
    }
}