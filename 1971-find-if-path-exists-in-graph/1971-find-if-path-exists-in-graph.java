class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:edges){
            int u=i[0];
            int v=i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean []visit=new boolean [n+1];
        return dfs(source,destination,visit,adj);

    }
    public boolean dfs(int src, int des, boolean [] visit, List<List<Integer>>adj){
        if(src==des){
            return true;
        }
        visit[src]=true;
        for(int i:adj.get(src)){
            if(!visit[i] && dfs(i,des,visit,adj)){
                return true;
            }
        }
        return false;
    }
}