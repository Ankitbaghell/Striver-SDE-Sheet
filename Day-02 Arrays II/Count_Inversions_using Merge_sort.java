import java.util.* ;

// by using merge sort ==> slight modification when we merge

public class Solution {
    static long merge(long[] arr,long[] temp, int start, int mid, int end){
        long count = 0;  //inversion count
        int i = start, j = mid;
        int k = start;
        
        while(i<= mid-1 && j<=end){
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else{            // taking from right 
                temp[k++] = arr[j++];
                count += (mid-i);      // counting the possible inversions
            }
        }
        
        while(i<=mid-1)
            temp[k++] = arr[i++];
        while(j<=end)
            temp[k++] = arr[j++];
        
        for(int z=start; z<=end; z++){
            arr[z] = temp[z];
        }
        
        return count;
        
    }
    
    static long mergeSort(long[] arr, int start, int end, long[] temp){
        long count=0;           //inversion count
        int mid;
        if(end > start){
            mid = (start+end)/2;
            count += mergeSort(arr, start, mid, temp);
            count += mergeSort(arr, mid+1, end, temp);

            count+= merge(arr, temp, start, mid+1, end);
        }
        return count;
    }
    public static long getInversions(long arr[], int n) {
        long[] temp = new long[n];   //for merging
        return mergeSort(arr, 0, n-1, temp);
    }
}