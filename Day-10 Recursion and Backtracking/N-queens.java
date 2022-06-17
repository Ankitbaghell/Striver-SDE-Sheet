
// in canFill function ==> moving from left to right so we have to check only for 3 directions (left, upperleft diagonal and lowleft diagonal) 

class Solution {
    List<String> construct(char[][] board){
       List<String> list = new ArrayList<>();
       for(char[] arr : board){
           list.add(new String(arr));
       }
        return list;
    }
    
//     boolean canFill(char[][] board,int row, int col){    
//         int originalRow = row, originalCol = col;
        
//         //upperleft diagonal
//         while(row >= 0 && col >= 0){
//             if(board[row][col] == 'Q')
//                 return false;
//             row--;
//             col--;
//         }
        
//         //left
//         row = originalRow;
//         col = originalCol;
//         while(col >= 0){
//             if(board[row][col] == 'Q')
//                 return false;
//             col--;
//         }
        
//         //lower left diagonal
//         row = originalRow;
//         col = originalCol;
//         while(row < board.length && col >= 0){
//             if(board[row][col] == 'Q')
//                 return false;
//             row++;
//             col--;
//         }
        
//         return true;
//     }
    
    void solve(char[][] board, int col, List<List<String>> ans, int leftRow[], int upperDiagonal[], int lowerDiagonal[]){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }
        
        for(int row = 0; row < board.length; row++){     //rows
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(board, col + 1, ans, leftRow, upperDiagonal, lowerDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
        }   
        
      }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for(char[] arr : board){
            Arrays.fill(arr, '.');
        }
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        
        solve(board, 0, ans, leftRow, upperDiagonal, lowerDiagonal);
        return ans;
    }
}
