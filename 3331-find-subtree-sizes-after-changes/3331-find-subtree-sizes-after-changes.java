// Brute Force ---- >> O(n2)
// class Solution {
//     public int[] findSubtreeSizes(int[] parent, String s) {
//         List<List<Integer>> adj=new ArrayList<>();
//         for(int i=0; i<parent.length; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=1; i<parent.length; i++){
//             int refParent=parent[i]; // ith node ka parent ky hai

//             while(s.charAt(refParent)!=s.charAt(i) && refParent!=0){
//                 refParent=parent[refParent];
//             }
//             if(s.charAt(i)==s.charAt(refParent)){  // equal mil gya toh refParent se append kardo
//                 adj.get(refParent).add(i);
//             }
//             else{
//                 adj.get(parent[i]).add(i);
//             }
//         }
//         // DFS se har node ka subtree size calculate karna
//         int[] ans = new int[parent.length];
//         dfs(0, adj, ans);

//         return ans;
//     }
//     public int dfs(int start, List<List<Integer>>adj, int [] ans){
//         int size=1;
//         for(int it:adj.get(start)){
//             size+=dfs(it,adj,ans);
//         }
//         ans[start]=size;
//         return size;
//     }
// }

// Optimal Approach

import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> oldAdj = new ArrayList<>(n);
        List<List<Integer>> newAdj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            oldAdj.add(new ArrayList<>());
            newAdj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            oldAdj.get(parent[i]).add(i);
        }

        Map<Character, Deque<Integer>> node = new HashMap<>();
        dfs(0, parent, s, oldAdj, newAdj, node);

        int[] ans = new int[n];
        dfs1(0, newAdj, ans);

        return ans;
    }

    private void dfs(int cur, int[] parent, String s,
                     List<List<Integer>> oldAdj, List<List<Integer>> newAdj,
                     Map<Character, Deque<Integer>> node) {
        char ch = s.charAt(cur);
        Deque<Integer> stack = node.computeIfAbsent(ch, k -> new ArrayDeque<>());

        if (stack.isEmpty()) {
            if (cur > 0) {
                newAdj.get(parent[cur]).add(cur);
            }
        } else {
            newAdj.get(stack.peekLast()).add(cur);
        }

        stack.addLast(cur);

        for (int u : oldAdj.get(cur)) {
            dfs(u, parent, s, oldAdj, newAdj, node);
        }

        stack.removeLast();
    }

    private void dfs1(int cur, List<List<Integer>> newAdj, int[] ans) {
        ans[cur] = 1;

        for (int u : newAdj.get(cur)) {
            dfs1(u, newAdj, ans);
            ans[cur] += ans[u];
        }
    }
}