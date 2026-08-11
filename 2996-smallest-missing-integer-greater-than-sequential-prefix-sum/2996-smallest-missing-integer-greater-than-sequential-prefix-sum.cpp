class Solution {
public:
    int missingInteger(vector<int>& nums) {
        int seq=nums[0];
        for(int i=1; i<nums.size(); i++){
            if(nums[i]==nums[i-1]+1){
                seq+=nums[i];
            }
            else{
                break;
            }
        }
        set<int>st;
        for(auto i:nums){
            st.insert(i);
        }
        while(st.count(seq)){
            seq++;
        }
        return seq;
    }
};