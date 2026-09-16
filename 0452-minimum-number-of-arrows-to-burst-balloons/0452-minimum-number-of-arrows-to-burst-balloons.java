class Solution {
    // Same copy paste of core logic of Non Overlapping intervals question(bs mey = wala case negate karenge)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int cnt=1,last=0;
        for(int i=1; i<points.length; i++){
            if(points[i][0]>points[last][1]){  // jisse hi koe non overlapping interval mile toj mtlb ki ek arrow ki requirement padegi agr overlapped hai toh mtlb usi current arrow se kam chal jayega
                cnt++;
                last=i;
            }
        }
        return cnt;
    }
}