class Solution {
    public boolean stoneGameIX(int[] stones) {
        int one=0,two=0,zero=0;
        for(int i:stones){
            int rem=i%3;
            if(rem==0){
                zero++;
            }
            else if(rem==1){
                one++;
            }
            else{
                two++;
            }
        }
        if(zero%2==0){
            return one>0 && two>0;
        }
        return Math.abs(one-two)>2;
    }
}