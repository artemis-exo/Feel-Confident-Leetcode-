class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visit=new boolean[rooms.size()];
        dfs(0,visit,rooms);

        for(boolean c:visit){
            if(!c){
                return false;
            }
        }
        return true;
    }
    public void dfs(int i, boolean [] visit, List<List<Integer>> rooms){
        visit[i]=true;
        for(int it:rooms.get(i)){
            if(!visit[it]){
                dfs(it,visit,rooms);
            }
        }
    }
}