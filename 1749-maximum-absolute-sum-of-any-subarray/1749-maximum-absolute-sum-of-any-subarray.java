class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int SumMax=0, SumMin=0;
        for(int i:nums){
            SumMax+=i;
            max=Math.max(max,SumMax);
            if(SumMax<0){
                SumMax=0;
            }
        }

         for(int i:nums){
            SumMin+=i;
            min=Math.min(min,SumMin);
            if(SumMin>0){
                SumMin=0;
            }
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}