class Solution {
    public int[] lexicographicallySmallestArray(int[] A, int limit) {
        int[] srt = A.clone();
        Arrays.sort(srt);
        List<List<Integer>> grps = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int id = -1;

        for (int i = 0; i < srt.length; i++) {
            if (i == 0 || srt[i] - srt[i - 1] > limit) {
                grps.add(new ArrayList<>());
                id++;
            }
            
            grps.get(id).add(srt[i]);
            map.put(srt[i], id);
        }

        int[] idx = new int[grps.size()];

        for (int i = 0; i < A.length; i++) {
            int cur = map.get(A[i]);
            A[i] = grps.get(cur).get(idx[cur]);
            idx[cur]++;
        }

        return A;
    }
}

// OPTIMAL APPROACH

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;
        int [][] m = new int[n][2];

        for(int i=0;i<n;i++){
            m[i][0]=nums[i];
            m[i][1]=i;
        }
        Arrays.sort(m,(a,b)-> a[0]-b[0]);

        int start = 0;
        while(start<n){

            int end = start;
            while(end+1<n && m[end+1][0]-m[end][0]<=limit){
                end++;
            }

            int [] indices = new int[end-start+1];
            for(int i=start;i<=end;i++){
                indices[i-start] = m[i][1];
            }

            Arrays.sort(indices);

            for(int i=0;i<indices.length;i++){
                nums[indices[i]]=m[start+i][0];
            }

            start=end+1;
        }
        return nums;
    }
}
