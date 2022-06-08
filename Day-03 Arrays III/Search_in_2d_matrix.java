class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int s = 0;
        int e = row * col - 1;
        int mid = (s + e)/2;
        
        while(s<=e){
            
            int midElement = matrix [mid / col] [mid % col];
            
            if(midElement == target) return true;
            
            else if(midElement > target) 
                e = mid - 1;
            
            else
                s = mid + 1;
            
            mid = (s + e)/2;
            
        }
      return false;  
    }
}