class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int stRow=0, stCol=0, endRow=n-1, endCol=m-1;

        while(stRow<= endRow && stCol<= endCol){
            for(int j=stCol; j<=endCol; j++){
                res.add(matrix[stRow][j]);
            }
            stRow++;
            for(int i=stRow; i<=endRow; i++){
                res.add(matrix[i][endCol]);
            }
            endCol--;
            if(stRow <= endRow){
                for(int j=endCol; j>=stCol; j--){
                    res.add(matrix[endRow][j]);
                }
                endRow--;
            }
            if(stCol <= endCol){
                for(int i=endRow; i>=stRow; i--){
                    res.add(matrix[i][stCol]);
                }
                stCol++;
        
            }
        }
        return res;
    }
}