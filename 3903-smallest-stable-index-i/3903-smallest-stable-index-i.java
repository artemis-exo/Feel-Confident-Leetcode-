class Solution {
    public int firstStableIndex(int[] nums, int k) {
       
        for(int i=0;i<nums.length;i++){
             int max=-1 , min=Integer.MAX_VALUE;
           for(int j=0;j<=i;j++){
              max=Math.max(max,nums[j]);
           }
           for(int p=i; p<nums.length; p++){
          min=Math.min(min,nums[p]);
           }
           if(max-min<=k){
            return i;
           }
        }
        return -1;
    }
}