class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    List<List<int[]>> adj=new ArrayList<>();
    for(int i=0; i<=n;i++){
        adj.add(new ArrayList<>());
    }
    for(int i[]:times){
        int u=i[0];
        int v=i[1];
        int w=i[2];

        adj.get(u).add(new int[]{v,w});
    }
    PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
    int [] dist=new int[n+1];
    Arrays.fill(dist,(int)1e9);
    dist[k]=0;
    pq.offer(new int[]{k,0});
    while(!pq.isEmpty()){
        int [] curr=pq.poll();
        int node=curr[0];
        int weight=curr[1];

        if(weight>dist[node])continue;

        for(int it []:adj.get(node)){
            int v=it[0];
            int wt=it[1];
            if(weight+wt<dist[v]){
                dist[v]=weight+wt;
                pq.offer(new int[]{v,dist[v]});
            }
        }
    }
       int res=0;
       for(int i=1; i<=n; i++){
        if(dist[i]==(int)1e9)
        return -1;
        res=Math.max(res,dist[i]);
       }
       return res;
    }
}