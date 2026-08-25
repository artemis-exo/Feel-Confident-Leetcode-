class Solution {
    public int missingMultiple(int[] nums, int k) {
          Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
         int check =k;
         while(true){
             if(!set.contains(check)){
                 return check;
             }
             check=check+k;
         }
    }
}