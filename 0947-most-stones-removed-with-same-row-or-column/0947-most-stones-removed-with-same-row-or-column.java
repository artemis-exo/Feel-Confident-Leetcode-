// ** Approach 1 Using DFS 
// Simple Intution Finding the Total number of connected components(stones) and Subtract it from Total Stones array length 

class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int cnt=0;
        boolean [] visit=new boolean[n];
        for(int i=0; i<n; i++){
             if(visit[i]==false){
                cnt++;
                dfs(i,visit,stones);
             }
        }
        return n-cnt;
    }
    public void dfs(int i, boolean[] visit,int [][] stones){    
        visit[i]=true;
        for(int k=0; k<stones.length; k++){    
            int row=stones[k][0];
            int col=stones[k][1];
            // Ist iteration wala (0,0) ka khud check(0,0) nhi hoga kyuki humne visit krdiya hai toh 0,0 ka next 0,1 se hoga
            if(!(visit[k]) && (stones[i][0]==row || stones[i][1]==col)){  
                dfs(k,visit,stones);
            }
        }
            
    }
}
