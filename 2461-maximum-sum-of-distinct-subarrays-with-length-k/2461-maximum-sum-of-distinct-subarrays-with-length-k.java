class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        long sum=0;
        long max=0;
        for(int i=0; i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum+=nums[i];
        }
        if(map.size()==k){
            max=Math.max(max,sum);
        }
        for(int i=k; i<nums.length; i++){
             sum+=nums[i]-nums[i-k];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            map.put(nums[i-k],map.getOrDefault(nums[i-k],0)-1);
            if(map.get(nums[i-k])==0){
                map.remove(nums[i-k]);  // map se issliye remove kare jai taki win ka size fix bne rhe aur duplicate element ka bhi pta chl jayega map ka size==k maintain krna hai
            }
            if(map.size()==k){
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}