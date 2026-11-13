// class Solution {

//     private long[] cumSum;

//     // Range Sum of nums[i..j], inclusive (0 if i > j)
//     private long rangeSum(int i, int j) {
//         if (i > j)
//             return 0;

//         return cumSum[j] - ((i > 0) ? cumSum[i - 1] : 0);
//     }

//     public long countNonDecreasingSubarrays(int[] nums, int k) {
//         int n = nums.length;

//         cumSum = new long[n];
//         cumSum[0] = nums[0];
//         for (int i = 1; i < n; i++) {
//             cumSum[i] = nums[i] + cumSum[i - 1];
//         }

//         // NGR[i] = index of next strictly greater element, or n if none
//         int[] NGR = new int[n];
//         Arrays.fill(NGR, n);
//         Deque<Integer> st = new ArrayDeque<>();
//         for (int i = 0; i < n; i++) {
//             while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
//                 NGR[st.pop()] = i;
//             }
//             st.push(i);
//         }

//         // Operations[i] = total operations to make [i...n-1] non-decreasing
//         long[] Operations = new long[n + 1];
//         for (int i = n - 1; i >= 0; i--) {
//             int m = NGR[i];

//             // i to m-1 segment
//             long segmentOprns = (1L * nums[i] * (m - i)) - rangeSum(i, m - 1);
//             Operations[i] = segmentOprns + Operations[m];
//         }

//         // Ready for Sliding Window Maximum
//         Deque<Integer> deq = new ArrayDeque<>();
//         long result = 0;
//         int i = 0;
//         int j = 0;

//         while (j < n) {

//             // decreasing order maintained - monotonic deque
//             while (!deq.isEmpty() && nums[deq.peekLast()] < nums[j]) {
//                 deq.pollLast();
//             }

//             deq.addLast(j);

//             // Shrink if required
//             while (i <= j) {
//                 int m = deq.peekFirst(); // index of window maximum

//                 // cost of [i...j]
//                 long oprnsCount = (Operations[i] - Operations[m])
//                                 + (1L * nums[m] * (j - m + 1))
//                                 - rangeSum(m, j);

//                 if (oprnsCount <= k)
//                     break;

//                 i++;
//                 if (deq.peekFirst() < i) {
//                     deq.pollFirst();
//                 }
//             }

//             result += (j - i + 1);
//             j++;
//         }

//         return result;
//     }
// }

// To understand

import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        // Each block: {value, count}; front = leftmost, values increase toward the back
        Deque<long[]> dq = new ArrayDeque<>();
        long cost = 0, ans = 0;
        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            long v = nums[l];
            long cnt = 1;

            // Merge front blocks that nums[l] now dominates
            while (!dq.isEmpty() && dq.peekFirst()[0] <= v) {
                long[] b = dq.pollFirst();
                cost += (v - b[0]) * b[1];
                cnt += b[1];
            }
            dq.offerFirst(new long[]{v, cnt});

            // Shrink from the right until the cost fits within k
            while (cost > k) {
                long[] last = dq.peekLast();
                cost -= last[0] - nums[r];
                r--;
                if (--last[1] == 0) dq.pollLast();
            }

            ans += r - l + 1;
        }
        return ans;
    }
}