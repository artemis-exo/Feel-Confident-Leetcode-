class Solution {
    public int minOperations(int[] nums) {
        int ascCnt=0,descCnt=0;
        int n=nums.length;
        for(int i=1; i<nums.length; i++){
            ascCnt+=(nums[i]==(nums[i-1]+1)%n)?1:0;
            descCnt+=(nums[i-1]==(nums[i]+1)%n)?1:0;
        }
        IO.println(ascCnt);
        IO.println(descCnt);
        if(ascCnt==n-1 && nums[0]==0){
            return 0;
            // phele se hi sorted hai
        }
        if(ascCnt==n-1){
            int leftRot=n-nums[0];
            int rightRot=1+(nums[n-1]+1)+1;
            return Math.min(leftRot,rightRot);
        }
        if(descCnt==n-1){
           // Manadatory 1 reverse
            int leftRot=n-nums[n-1]+1;
            // LeftRot+1 Reverse
            int rightRot=(nums[0]+1)%n+1;
            return Math.min(leftRot,rightRot);

        }
        return -1;
    }
}