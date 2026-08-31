class Solution {
    public String[] largestString(int[] nums) {
        String[] res = new String[nums.length];

        int j = 0;

        for (int num : nums) {
            StringBuilder sb = new StringBuilder();

            int z = 1 << 25;

            for (int i = 0; i < num / z; i++) {
                sb.append('z');
            }

            num %= z;

            for (int i = 24; i >= 0; i--) {
                if (((num >> i) & 1) == 1) {
                    sb.append((char) ('a' + i));
                }
            }

            res[j] = sb.toString();
            j++;
        }

        return res;
    }
}