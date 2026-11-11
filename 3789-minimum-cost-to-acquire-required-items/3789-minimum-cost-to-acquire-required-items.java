class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // int max=Math.max(need1,need2);
        // int chota=Math.min(need1,need2);
        // long both=costBoth*max;
        //  long we=0;
        // if(chota==need2){
        //     we=(need1-need2)*cost1;
        // }
        // else if(chota==need1){
        //   we=(need2-need1)*cost2;
        // }
        // long sum=(cost1*need1)+(cost2*need2);
        // long min=Math.min(sum,both);
        // we=we+both;
        // min=Math.min(min,we);

        // // min of need1 and need2
        // // usse phir costBoth multiply

         long total=0;
        if(cost1 +cost2<=costBoth){
            total=1L*cost1*need1 + 1L*need2*cost2;
        }
        else{
            int both=Math.min(need1,need2);
            total=1L*both*costBoth;

            need1=need1-both;
            need2=need2-both;

            if(need1>0){
                total+=1L*need1*Math.min(cost1,costBoth);
            }
            else if(need2>0){
                total+=1L*need2*Math.min(cost2,costBoth);
            }
        }

        return total;
    }
}