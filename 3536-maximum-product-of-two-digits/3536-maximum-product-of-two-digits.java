class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(); // min heap so that if threshold of 2 reaches the max elemnts only remain
        while(n>0){
            int digit=n%10;
            pq.offer(digit);
            if(pq.size()>2)
            pq.poll();
            n/=10;
        }
        return pq.poll() * pq.poll();
    }
}