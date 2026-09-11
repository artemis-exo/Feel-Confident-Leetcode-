class Solution {
    public boolean lemonadeChange(int[] bills) {
         /*
         1 ---- > Humko coins diye gaye hai $5, $10, $20 , each lemonade ki cost $5 hain 
         2 --- > agr $5 dollar ka hua toh humko koe change nhi dena wapas simple $5 dolllar ke denoominations++
         3  --- > agr $10 dollar ka hua toh humko $5 ka change return krna krna hai iske liye amount of $5 >1
         4 ---- > agr $20  ka hua toh 2 cases bange ya toh 1-1 $5 and $10 ka denge return
            --- >> ya toh agr $10 ka nhi hua toh amount of $5 >=3 toh possible rteurn ho jayega
        5   ---- > nhi toh return false 
         */
         int five=0, ten=0;
         for(int i:bills){
           if(i==5){
            five++;
           }
           else if(i==10){
            if(five>=1){
            five--;
            ten++;
            }
            else{
                return false;
            }
           }
           else{
            if(five>=1 && ten >=1){
                five--;
                ten--;
            }
            else if(five >=3){
                five=five-3;
            }
            else{
                return false;
            }
           }
         }
         return true;
    }
}