import java.util.*;

public class Matrices {
    public static void printMatrix(int matrix[][]) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void searchMaxAndMin(int matrix[][]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, matrix[i][j]);
                min = Math.min(min, matrix[i][j]);
            }
        }
        System.out.println("Maximum value is: " + max);
        System.out.println("Minimum value is: " + min);
    }

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol) {
            //top
            for(int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            //Right
            for(int i = startRow+1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            //bottom
            for(int j = endCol-1; j >= startCol; j--) {
                if(startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            //left
            for(int i = endRow-1; i >= startRow+1; i--) {
                if(startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i == j) {
                    sum += matrix[i][j];
                }
                if(i+j == matrix.length-1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static int diagonalSumOptimized(int matrix[][]) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if(i != matrix.length-1-i)
                sum += matrix[i][matrix.length-1-i];
        }
        return sum;
    }

    public static boolean stairCaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix.length-1;

        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == key) {
                System.out.println("Key is found on index (" + row + ", " + col + ")");
                return true;
            }

            if(key > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static int countNumOfOccurence(int matrix[][], int num) {
        int count = 0;
    
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == num) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int sumOfSecondRow(int matrix[][]) {
        int sum = 0;
            for(int j = 0; j < matrix[0].length; j++) {
                sum += matrix[1][j];
            }
        return sum;
    }

    public static int[][] transposeOfMatrix(int matrix[][]) {
        int row = matrix.length, col = matrix[0].length;
        int transposeMatrix[][] = new int[col][row];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }

    public static void sumOfMatrix(int[][] a, int r1, int c1, int[][] b, int r2, int c2) {
        if(r1 != r2 && c1 != c2) {
            System.out.println("Wrong input! demensions are not equal.");
            return;
        }

        int[][] sum = new int[r1][c2];

        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c2; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        printMatrix(sum);
    }

    public static void multiplicationOfMatrix(int[][] a, int r1, int c1, int[][] b, int r2, int c2) {
        if(c1 != r2) {
            System.out.println("Multiplication not possible.");
            return;
        }

        int mul[][] = new int[r1][c2];

        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c2; j++) {
                for(int k = 0; k < c1; k++) {
                    mul[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        printMatrix(mul);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row: ");
        int r1 = sc.nextInt();
        System.out.print("Enter column: ");
        int c1 = sc.nextInt();

        int a[][] = new int[r1][c1];

        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter row: ");
        int r2 = sc.nextInt();
        System.out.print("Enter column: ");
        int c2 = sc.nextInt();

        int b[][] = new int[r2][c2];

        for(int i = 0; i < r2; i++) {
            for(int j = 0; j < c2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        multiplicationOfMatrix(a, r1, c1, b, r2, c2);

        sc.close();
    }
}

// int sc[][] = {
//     {10, 20, 30, 40},
//     {15, 25, 35, 45},
//     {27, 29, 37, 48},
//     {32, 33, 39, 50},
// };