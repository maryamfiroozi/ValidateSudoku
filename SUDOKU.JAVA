public class Sudukou {
    public static void main(String[] args) {
        char[][] digits = {{'.','.','.','.','5','.','.','1','.'},
                            {'.','4','.','3','.','.','.','.','.'},
                            {'.','.','.','.','.','3','.','.','1'},
                            {'8','.','.','.','.','.','.','2','.'},
                            {'.','.','2','.','7','.','.','.','.'},
                            {'.','1','5','.','.','.','.','.','.'},
                            {'.','.','.','.','.','2','.','.','.'},
                            {'.','2','.','9','.','.','.','.','.'},
                            {'.','.','4','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(digits));

    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                for (int k=0; k<9; k++){
                    if(board[i][j] != '.' && board[i][j] == board[i][k] && j!=k){
                        return false;
                    }
                    if(board[j][i] != '.' && board[j][i] == board[k][i] && k!=j){
                        return false;
                    }
                }

            }
        }
        int m=0;
        int n=0;
        for(int i=0; i<9; i++) {
            if(i<3)
                n=0;
            else if(2<i && i<6)
                n=3;
            else if(i>=6)
                n=6;
            for (int j = 0; j < 9; j++) {
                if(j%3 == 0)
                    m=j;

                else if(j%3 == 1)
                    m = j -1;

                else if(j%3 == 2)
                    m= j-2;
                for (int k = m; k < m+3; k++) {
                    for (int r = n; r < n+3; r++) {
                        if(board[i][j]=='.')
                            break;
                        if(board[i][j]==board[r][k] && i!=r && j!=k){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
