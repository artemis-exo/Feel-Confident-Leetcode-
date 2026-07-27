class Solution {
    public int maxProduct(int[] nums) {
        // Approach 1
        // Same Second largest element Template
        int largest=-1, second=-1;
        for(int i:nums){
            if(i>largest){
                second=largest;
                largest=i;
            }
            else if(i>second){
                second=i;
            }
        }
        return (largest-1) *(second-1);
    }
}

// Approach 2 - ** Using Min Heap
class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
         for(int i:nums){
            pq.offer(i);
            if(pq.size()>2)
            pq.poll();
        }
        return (pq.poll()-1)*(pq.poll()-1);
    }
}
