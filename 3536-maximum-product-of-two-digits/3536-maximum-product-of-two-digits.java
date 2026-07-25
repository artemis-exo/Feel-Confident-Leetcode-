// class Solution {
//     public int maxProduct(int n) {
//         PriorityQueue<Integer>pq=new PriorityQueue<>(); // min heap so that if threshold of 2 reaches the max elemnts only remain
//         while(n>0){
//             int digit=n%10;
//             pq.offer(digit);
//             if(pq.size()>2)
//             pq.poll();
//             n/=10;
//         }
//         return pq.poll() * pq.poll();
//     }
// }

// Little Optimization removing Extra space and poll() overhead of Priority queue
// Simple intution we need 2 max element so simply implement the secong largest element Template
class Solution {
    public int maxProduct(int n) {
        int largest=-1, second=-1;
        while(n>0){
            int digit= n%10;
            if(digit>=largest){
              second=largest;
              largest=digit;
            }
            else if(second<digit){
                second=digit;
            }
            n/=10;
        }
        return largest*second;
    }
}