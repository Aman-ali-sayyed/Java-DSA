public class Backtracking {
    public static void printArray(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArr(int arr[], int i, int val) {
        //base case
        if(i == arr.length) {
            printArray(arr);
            return;
        }
        //recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i]-2; //backtracking
    }

    public static void inputA() {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArray(arr);
    }

    public static void findSubset(String str, String ans, int i) {
        //base case
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        //Recursion
        //Choice
        //Yes
        findSubset(str, ans+str.charAt(i), i+1);
        //No
        findSubset(str, ans, i+1);
    }

    public static void inputB() {
        String str = "abc";
        findSubset(str, "", 0);
    }

    public static void findPermutation(String str, String ans) {
        //base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, ans+curr);
        }
    }

    public static void inputC() {
        String str = "abc";
        findPermutation(str, "");
    }

    static int count = 0;

    public static boolean nQueens(char board[][], int row) {
        //base case 
        if(row == board.length) {
            printBoard(board);
            // count++;
            return true;
        }
        for(int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j) == true) {
                board[row][j] = 'Q';
                if(nQueens(board, row+1)) return true; //recursion
                nQueens(board, row+1);
                board[row][j] = 'x'; //backtracking step
            }
        }
        return false;
    }

    public static boolean isSafe(char board[][], int row, int col) {
        //vertical 
        for(int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        //right up diagonal
        for(int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        //left up diagonal
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("_________________chess board____________________");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void inputD() {
        int n = 4;
        char board[][] = new char[n][n];
        //initialize
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = 'x';
            }
        }

        nQueens(board, 0);
    }

    public static int gridWays(int i, int j, int n, int m) {
        if(i == n-1 && j == m-1) {
            return 1;
        } else if(i == n || j == n) {
            return 0;
        }
        int right = gridWays(i, j+1, n, m);
        int down = gridWays(i+1, j, n, m);
        int totalWays = right + down;

        return totalWays;
    }

    public static void inputE() {
        int n = 3, m = 3;
        System.out.println(gridWays(0, 0, n, m));
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        //base case
        if(row == 9) {
            return true;
        }

        //recursion
        int newRow = row, nextCol = col+1;
        if(col+1 == 9) {
            newRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, newRow, nextCol);
        }
        for(int digit = 1; digit <= 9; digit++) {
            if(isSafeForSudoku(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, newRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafeForSudoku(int sudoku[][], int row, int col, int digit) {
        //column
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }

        //row
        for(int j = 0; j < 9; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }

        //3x3 grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i = sr; i < sr+3; i++) {
            for(int j = sc; j < sc+3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printSudoku(int sudoku[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void inputF() {
        int sudoku[][] = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3},
        };

        if(sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution does not exists");
        }
    }

    public static void printMaze(int soln[][]) {
        for(int i = 0; i < soln.length; i++) {
            for(int j = 0; j < soln.length; j++) {
                System.out.print(soln[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveMaze(int maze[][]) {
        int n = maze.length;
        int soln[][] = new int[n][n];

        if(solveMazeUtil(maze, 0, 0, soln) == false) {
            System.out.println("solution does not exists");
            return false;
        }
        
        printMaze(soln);
        return true;
    }

    public static boolean isSafeForMaze(int maze[][], int row, int col) {
        return (row >= 0 && row < maze.length && col >= 0 && col < maze.length && maze[row][col] == 1);
    }

    public static boolean solveMazeUtil(int maze[][], int row, int col, int soln[][]) {
        if(row == maze.length-1 && col == maze.length-1 && maze[row][col] == 1) {
            soln[row][col] = 1;
            return true;
        }

        if(isSafeForMaze(maze, row, col) == true) {
            if(soln[row][col] == 1) {
                return false;
            }
            soln[row][col] = 1;

            if(solveMazeUtil(maze, row+1, col, soln)) {
                return true;
            }
            if(solveMazeUtil(maze, row, col+1, soln)) {
                return true;
            }
            soln[row][col] = 0;
            return false;
        }
        return false;
    }

    public static void inputG() {
        int maze[][] = {{ 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 0 },
                        { 1, 1, 1, 1 }};

        solveMaze(maze);
    }

    static char L[][] = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void combination(String D) {
        int len = D.length();
        if(len == 0) {
            System.out.println("");
        }

        bfs(0, new StringBuilder(), len, D);
    }

    public static void bfs(int pos, StringBuilder sb, int len, String D) {
        if(pos == len) {
            System.out.println(sb.toString());
            return;
        }

        else {
            char letters[] = L[Character.getNumericValue(D.charAt(pos))];
            for(int i = 0; i < letters.length; i++) {
                bfs(pos+1, new StringBuilder(sb).append(letters[i]), len, D);
            }
        }
    }

    public static void inputH() {
        String digits = "23";
        combination(digits);
    }
    public static void main(String[] args) {
        inputC();
    }
}
