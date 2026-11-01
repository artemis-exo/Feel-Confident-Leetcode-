class Solution {
    public int minMoves(int[] nums) {
        // First finging min
        long ops=0;
        int max=Integer.MAX_VALUE;
        for(int i:nums){
            max=Math.min(max,i);
        }
        // min element se kitne dur hai elements utne hi steps laganege
        for(int i:nums){
            ops+=i-max;
        }
        return (int)ops;
    }
}