class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> st=new HashSet<>();
        Set<Integer> s=new HashSet<>();
        for(int i=0; i<nums.length;i++){
            for(int j=i;j<nums.length; j++){
                st.add(nums[i]^nums[j]);  // // Sub arrays type xor compute krliya beacuse common 
            }
        }
        for(int i:st){  // then with k
            for(int j:nums){
                s.add(i^j);
            }
        }
        return s.size();
    }
}
