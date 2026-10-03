class Solution {
    public boolean dfs(char[][] board, int r, int c, String word, int wordIdx){
        // base case
        if(wordIdx == word.length()){
            return true;
        }
        // out of bound case
        int m = board.length;
        int n = board[0].length;
        if(r < 0 || c < 0 || r >= m || c >= n){
            return false;
        }
        // invalid case
        if(board[r][c] == ' ' || board[r][c] != word.charAt(wordIdx)){
            return false;
        }
        // mark ase visited
        char ch = board[r][c];
        board[r][c] = ' ';
        //dfs calls
        if(dfs(board, r - 1, c, word, wordIdx + 1) ||
            dfs(board, r, c + 1, word, wordIdx +1) ||
            dfs(board, r + 1, c, word, wordIdx +1)||
            dfs(board, r, c - 1, word, wordIdx +1 )){
            return true;
        }
        //backtraking
        board[r][c] = ch;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int r = 0; r < rows ; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == word.charAt(0)){
                    boolean found =  dfs(board, r, c, word, 0);
                    if(found) return true;
                }
                

            }
        }
        return false;
    }
}