class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int res=0;
        for(int i=0; i<n;i++){
             boolean check []=new boolean[102];
             int cnt=0;
            for(int j=i; j<n;j++){
                int bec=nums.get(j);
                if(!check[bec]){
                    check[bec]=true;
                    cnt++;
                }
                res=res+(cnt*cnt);
            }
        }
        return res;
    }
}