class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer>li=new ArrayList<>();
        boolean flag[]=new boolean[nums.length];
        Permutee(nums,li,flag);
        return res;
    }
    public void Permutee(int nums[] , List<Integer> li, boolean [] flag){
        if(nums.length==li.size()){
            res.add(new ArrayList<>(li));
            return;
        }
        for(int i=0; i<nums.length;i++){
            if(flag[i])
            continue;
            li.add(nums[i]);
            flag[i]=true;
            Permutee(nums, li,flag);
            flag[i]=false;
            li.remove(li.size()-1);
        }
    }
}