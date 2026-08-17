class Solution {
     List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
       List<Integer> li=new ArrayList<>();
       Combine(1,n,k,li);
       return res;
    }
    public void Combine(int i, int n, int k, List<Integer>li){
        if(li.size()==k){
            res.add(new ArrayList<>(li));
            return;
        }
        if(i>n){
            return;
        }
        li.add(i);
        Combine(i+1,n,k,li);
        li.remove(li.size()-1);
        Combine(i+1,n,k,li);
    }
}