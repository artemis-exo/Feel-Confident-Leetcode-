class Solution {
    long MOD=(int)1e9+7;
    long [] sum, sqSum, lazy;
    int n;
    public int sumCounts(int[] nums) {
        n=nums.length;
        sum=new long[4*n];
        sqSum=new long[4*n];
        lazy=new long[4*n];

        int lastSeen[]=new int[100001];
        Arrays.fill(lastSeen,-1);
        long res=0;
        for(int i=0; i<n; i++){
            int start=lastSeen[nums[i]]+1;
            int end=i;
            update(0,0,n-1,start,end,1);
            res=(res+sqSum[0])%MOD;
            lastSeen[nums[i]]=i;
        } 
        return (int)res;
    }
    public void apply(int node, int l, int r, long val){
    long len=r-l+1;
    sqSum[node]+=2*val*sum[node]+len*val*val;
    sum[node]+=len*val;
    lazy[node]+=val;
    }
    public void push(int node, int l, int r){
        if(lazy[node]!=0){
            int mid=l+(r-l)/2;
            apply(2*node+1,l,mid,lazy[node]);
            apply(2*node+2,mid+1,r,lazy[node]);
            lazy[node]=0;
        }
    }
    public void update(int node, int l, int r , int ql, int qr, long val){
        if(ql>r || qr<l){
            return;
        }
        if(ql<=l && qr>=r){
            apply(node,l,r,val);
            return;
        }
        push(node,l,r);
        int mid=l+(r-l)/2;
        update(2*node+1,l,mid,ql,qr,val);
        update(2*node+2,mid+1,r,ql,qr,val);
        sum[node]=sum[2*node+1]+sum[2*node+2];
        sqSum[node]=sqSum[2*node+1]+sqSum[2*node+2]; 
    }
}