class Solution {
    public boolean isSafe(char[][] board, int row, int col){
        //vertically up
        for(int i=row-1; i >=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // right up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public void nQueens(char[][] board, int row, List<List<String>> ans){
        //base
        if(row == board.length){
           //covert board into list of string
           List<String> temp = new ArrayList<>();
           for(char[] r : board){
                temp.add(new String(r));
           }  
           ans.add(new ArrayList<>(temp));
           return;
        }

        //recursion
        for(int j=0; j<board.length; j++){
            if(isSafe(board,row,j) == true){
                board[row][j] = 'Q';
                nQueens(board, row+1, ans);
                board[row][j] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++){
           for( int j=0; j<n; j++){
                board[i][j] = '.';
           }
        }

        List<List<String>> ans = new ArrayList<>();
        nQueens(board,0,ans);
        return ans;
    }
}