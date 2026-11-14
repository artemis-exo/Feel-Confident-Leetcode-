class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int [] pre=new int[nums.size()];
        pre[0]=nums.get(0);
        for(int i=1; i<nums.size();i++){
           pre[i]=pre[i-1]+nums.get(i);
        }
        int j=0,i=0;
        int min =Integer.MAX_VALUE;
        int sum=0;
        while(i<nums.size()){
            if(j>=nums.size()){
                i++;
                j=i;
                continue;
            }
            int win=j-i+1;
            if(win>=l && win<=r){
                sum=(i==0)?pre[j]:pre[j]-pre[i-1];
                if(sum>0){
                   min=Math.min(min,sum);
                }
               j++; 
            }
            else if (win>r){
                i++;
                j=i;
            }
            else {
                j++;
            }
        
        }
       return min==Integer.MAX_VALUE?-1:min;
    }
}