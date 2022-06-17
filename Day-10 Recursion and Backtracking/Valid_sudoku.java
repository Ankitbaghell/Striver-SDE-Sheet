class Solution {
    public boolean isValidSudoku(char[][] board) {    //9*9 board
        HashSet<String> visited = new HashSet<>();
        for(int i=0; i<9; i++){
            for(int j =0; j<9; j++){
                if(board[i][j] != '.'){   // means number is present
                    if(!visited.add("row"+i+board[i][j]) || !visited.add("col"+j+board[i][j])){   //duplicate data in row ya col
                        return false;
                    }
                     if(!visited.add("box"+ ((i/3)*3 + j/3) +board[i][j])){   //duplicate data in 3*3 sub-matrix
                        return false;
                    }
                }
            }
        }
       return true; 
    }
}