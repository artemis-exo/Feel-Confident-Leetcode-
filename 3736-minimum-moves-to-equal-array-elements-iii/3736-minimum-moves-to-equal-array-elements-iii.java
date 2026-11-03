class Solution {
    public int minMoves(int[] nums) {
        int moves=0;
        int max=-1;
        for(int i:nums){
            if(i>max){
                max=i;
            }
        }
        for(int i:nums){
            moves+=max-i;
        }
        return moves;
    }
}