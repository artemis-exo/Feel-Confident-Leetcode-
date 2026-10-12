class Solution {
    public String largestOddNumber(String num) {
          if((int)num.charAt(num.length()-1)%2==1)return num;
        for (int i = num.length() - 2; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}