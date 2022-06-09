import java.util.* ;
import java.io.*; 
public class Solution{
    public static int[][] pairSum(int[] arr, int s) {
        ArrayList<int[]> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int reqNum = s - arr[i];
            if(map.get(reqNum) != null){    // if present
                int c = map.get(reqNum);
                while(c!=0){
                    if(reqNum<arr[i])
                        list.add(new int[]{reqNum, arr[i]});
                    else
                        list.add(new int[]{arr[i], reqNum});
                    c--;
                }
            }
          map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        
        int[][] ans = new int[list.size()][2];
        int k = 0;
        for(int[] x : list){
            ans[k][0] = x[0];
            ans[k][1] = x[1];
            k++;
        }
        Arrays.sort(ans, (a,b)->(a[0]-b[0]));
        return ans;
    }
}