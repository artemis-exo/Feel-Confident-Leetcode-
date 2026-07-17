class DSU{
    int [] parent, size;
    DSU(int n){
        parent=new int[n];
        size=new int[n];

        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int node){
        if(parent[node]==node)
        return node;

        return parent[node]=find(parent[node]);
    }
    void union(int u, int v){
        int rootU=find(u);
        int rootV=find(v);
        if(rootU==rootV)
        return ;
        if(size[rootU]<size[rootV]){
            parent[rootU]=rootV;
            size[rootV]+=size[rootU];
        }
        else{
            parent[rootV]=rootU;
            size[rootU]+=size[rootV];
        }
    }

}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;

        DSU d=new DSU(n);
        int  comp=n;
        for(int i[]:connections){
            int u=i[0];
            int v=i[1];
            if(d.find(u)!=d.find(v)){
                d.union(u,v);
                comp--;
            }
        }
        return comp-1;
    }
}