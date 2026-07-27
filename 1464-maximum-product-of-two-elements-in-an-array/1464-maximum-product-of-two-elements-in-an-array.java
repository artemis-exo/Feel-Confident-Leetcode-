class Solution {
    public int maxProduct(int[] nums) {
        // Approach 1
        // Same Second largest element Template
        int largest=-1, second=-1;
        for(int i:nums){
            if(i>largest){
                second=largest;
                largest=i;
            }
            else if(i>second){
                second=i;
            }
        }
        return (largest-1) *(second-1);
    }
}