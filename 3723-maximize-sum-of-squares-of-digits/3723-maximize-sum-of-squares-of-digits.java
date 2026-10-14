class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>num*9){// agr nums*9 krne pe bhi sum greater hai means not possible
            return "";
        }
        StringBuilder sb=new StringBuilder();
        int nine=sum/9; // number of nines maximize krne hai takki max se max ans aye
        int rem=sum%9;  // bkki rem number ko append krdenge
        for(int i=0; i<nine;i++){
           sb.append('9');
        }
        if(rem>0){
            sb.append((char)(rem+'0'));
        }
        while(sb.length()<num){
            sb.append('0');     // agr forming string ki length desired num se kam hai toh 0 append krdenge takki condition satisfy hojaye
        }
        return sb.toString();

    }
}