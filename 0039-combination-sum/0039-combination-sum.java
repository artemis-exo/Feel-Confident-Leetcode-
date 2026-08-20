class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>li=new ArrayList<>();
        dfs(candidates,target,0,li);
        return res;
    }
    public void dfs(int [] nums, int target, int i, List<Integer>li){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(li));
            return;
        }
        for(int j=i; j<nums.length; j++){
        li.add(nums[j]);
        dfs(nums,target-nums[j],j,li);
        li.remove(li.size()-1);
        }
       
    }
}