class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int n=nums.size();
        long sum=0, Xor=0;
        for(auto i:nums){
            Xor^=i;
            sum+=i;
        }
        if(sum==0)return 0; // This check is only for Test case 1002 (1 and only Last Test case)
        // If Entire nums array is filled with 0's
        return Xor==0?n-1:n;
    }
};