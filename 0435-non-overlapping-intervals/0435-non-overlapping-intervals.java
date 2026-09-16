class Solution {

    // Meetings rooms jaise same logic krte hai 
    // a[1] ke basis pe sort krte hai takki overlapping check kr paye future ke liye

    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
       // IO.println(Arrays.toString(intervals));

        int last=0,cnt=1; // ek interval to by default hemsha hoga
        for(int i=1; i<n; i++){
            if(intervals[i][0]>=intervals[last][1]){
                cnt++;
                last=i;
            }
        }
        return n-cnt;
    }
}