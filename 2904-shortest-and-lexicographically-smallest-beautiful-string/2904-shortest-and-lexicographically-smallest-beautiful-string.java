class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0, ones = 0;
        String res = "";

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                ones++;
            }

            // Shrink window from the left if we have excess 1s or leading 0s
            while (ones > k || (i <= j && ones == k && s.charAt(i) == '0')) {
                if (s.charAt(i) == '1') {
                    ones--;
                }
                i++;
            }

            // Valid window with exactly k ones
            if (ones == k) {
                String temp = s.substring(i, j + 1);
                if (res.isEmpty() || temp.length() < res.length() || 
                   (temp.length() == res.length() && temp.compareTo(res) < 0)) {
                    res = temp;
                }
            }
        }

        return res;
    }
}