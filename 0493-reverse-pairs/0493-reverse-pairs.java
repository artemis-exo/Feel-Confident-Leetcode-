// class Solution {
//     public int reversePairs(int[] nums) {
//         long cnt=0;
//         for(int i=0; i<nums.length-1; i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]>2L*nums[j]){
//                     cnt++;
//                 }
//             }
//         }
//         return (int)cnt;
//     }
// }

class Solution {
    public int reversePairs(int[] nums) {
        int count = Inversions(nums,nums.length);
        return count;
    }

    public static int Inversions(int [] arr, int N){
        return mergeSort(arr,0,N-1);
    }
    public static int mergeSort(int [] arr,int low,int high){
        int cnt=0;
        if(low>=high){
            return cnt;
        }
        int mid=(low+high)/2;
        cnt+=mergeSort(arr,low,mid);
       cnt+= mergeSort(arr,mid+1,high);
        cnt+=merge(arr,low,mid,high);
        return cnt;
    }
    public static int merge(int[] arr, int low, int mid, int high) {

    int cnt = 0;

    // Count reverse pairs
    int right = mid + 1;
    for (int left = low; left <= mid; left++) {
        while (right <= high && arr[left] > 2L * arr[right]) {
            right++;
        }
        cnt += right - (mid + 1);
    }

    // Normal merge
    int[] temp = new int[high - low + 1];

    int left = low;
    right = mid + 1;
    int k = 0;

    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp[k++] = arr[left++];
        } else {
            temp[k++] = arr[right++];
        }
    }

    while (left <= mid) {
        temp[k++] = arr[left++];
    }

    while (right <= high) {
        temp[k++] = arr[right++];
    }

    for (int i = low; i <= high; i++) {
        arr[i] = temp[i - low];
    }

    return cnt;
}

}