class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer>li=new ArrayList<>();
        boolean [] flag=new boolean[nums.length];
        Arrays.sort(nums);  // sort to group duplicates
        back(nums,flag,li);
        return res;
    }
    public void back(int [] nums, boolean [] flag, List<Integer>li){
        if(li.size()==nums.length){
            res.add(new ArrayList<>(li));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(flag[i])
            continue;
             if(i>0 &&nums[i-1]==nums[i] && !flag[i-1]) continue;  //  skip duplicates
            li.add(nums[i]);
            flag[i]=true;
            back(nums,flag,li);
            flag[i]=false;
            li.remove(li.size()-1);
        }
    }
}