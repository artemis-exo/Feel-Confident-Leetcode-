class NumArray {
    class SegTree{
        int start,end, sum;
        SegTree left,right;

        public SegTree(int start, int end){
            this.start=start;
            this.end=end;
            this.sum=0;
            this.left=this.right=null;
        }
    }
    SegTree root=null;
    public NumArray(int[] nums) {
        root=buildTree(nums,0,nums.length-1);
        
    }
    public SegTree buildTree(int[] nums, int start, int end){
        if(start>end)
        return null;
        else{
            SegTree node=new SegTree(start,end);
            if(start==end){
             node.sum=nums[start];
             return node;
        }
            else{
                int mid=start+(end-start)/2;
                node.left=buildTree(nums,start,mid);
                node.right=buildTree(nums,mid+1,end);
                node.sum=node.left.sum+node.right.sum;
            }
            return node;
        }
    }
    
    public void update(int idx, int val) {
        update(root,idx,val);
        
    }
    public void update(SegTree root, int idx, int val){
        if(root.start==root.end){
            root.sum=val;
            return;
        }
        else{
            int mid=root.start+(root.end-root.start)/2;
            if(idx<=mid){
            update(root.left,idx,val);
            }
            else{
                update(root.right,idx,val);
            }
            root.sum=root.left.sum+root.right.sum;
        }
    }
    
    public int sumRange(int l, int r) {
        return sumRange(root,l,r);
    }
    public int sumRange(SegTree root, int l, int r){
        if(root==null || root.start>r || root.end<l)
        return 0;
        if(root.start>=l && root.end<=r){
            return root.sum;
        }
        return sumRange(root.left,l,r)+sumRange(root.right,l,r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */