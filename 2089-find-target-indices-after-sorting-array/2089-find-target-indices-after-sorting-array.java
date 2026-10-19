class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer>li=new ArrayList<>();
        Arrays.sort(nums);
        int start=0, end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                int left=mid;
                while(left>=0 && nums[left]==target){
                    li.add(left);
                    left--;
                }
                int right=mid+1;
                while(right<nums.length && nums[right]==target){
                    li.add(right);
                    right++;
                }
                break;
            }
           
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{start=mid+1;}
        }
        Collections.sort(li);
        return li;
    }
}