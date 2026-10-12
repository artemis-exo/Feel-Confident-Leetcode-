class Solution {
    public String reverseStr(String s, int k) {
        char arr[]=s.toCharArray();
        int steps=2*k; // kinte ka jump leke char ko reverse krna hai
        for(int i=0; i<arr.length;i+=steps){
            int start=i;
            int end=Math.min(i+k-1,arr.length-1);

            while(start<end){
                char temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;

                start++;
                end--;
            }
        }
        return new String(arr);
    }
}