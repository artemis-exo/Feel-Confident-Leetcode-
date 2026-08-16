class Solution {
    public int brokenCalc(int startValue, int target) {
        int cnt=0;
        while(startValue<target){
            if(target%2==0){
                target=target >> 1;
            }
            else{
                target++;
            }
            cnt++;
        }
        // if target startValue se chota ho jaye toh mtlb kam pura nhi hua hai , means we need one extra step to Equalize both of them
        return cnt+(startValue-target);
    }
}