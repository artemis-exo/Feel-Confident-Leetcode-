class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
       Arrays.sort(logs,(a,b)-> Integer.compare(a[1],b[1])); // sorting server time in ASC 
       int qt[][]=new int [queries.length][2];
       for(int i=0; i<queries.length; i++){
        qt[i][0]=queries[i]; // query ka time
        qt[i][1]=i;  // uski index
       }
       Arrays.sort(qt,(a,b)->Integer.compare(a[0],b[0]));
       int [] arr=new int [queries.length];
       int idCnt[]=new int[n+1];
       int active=0;
       int left=0;
       int right=0;

       for(int i=0; i<queries.length; i++){
        int endTime=qt[i][0];
        int startTime=qt[i][0]-x;
        int idx=qt[i][1];

        while(right<logs.length && logs[right][1]<=endTime){
            int serverId=logs[right][0];
            if(idCnt[serverId]==0){
                active++;
            }
            idCnt[serverId]++;
            right++;

        }
        while(left<right && logs[left][1]<startTime){
            int serverId=logs[left][0];
            idCnt[serverId]--;
            if(idCnt[serverId]==0){
                active--;
            }
            left++;
        }
        arr[idx]=n-active;
       }
       return arr;
    }
}