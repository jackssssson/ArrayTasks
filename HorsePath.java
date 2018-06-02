import java.util.Scanner;

public class HorsePath {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        int count = 1;

        matrix[0][0] = count;
        count++;

        int[][] horseMove = new int[8][2];
        horseMove[0][0] = -2; horseMove[0][1] = -1;
        horseMove[1][0] = -2; horseMove[1][1] = 1;
        horseMove[2][0] = -1; horseMove[2][1] = -2;
        horseMove[3][0] = -1; horseMove[3][1] = 2;
        horseMove[4][0] = 1; horseMove[4][1] = -2;
        horseMove[5][0] = 1; horseMove[5][1] = 2;
        horseMove[6][0] = 2; horseMove[6][1] = -1;
        horseMove[7][0] = 2; horseMove[7][1] = 1;

        int currentRow = 0;
        int currentColl = 0;

        int indexRow;
        int indexColl;

        for (int i = 0; i < n * n; i++){
            boolean canMove = false;

            for (int j = 0; j < 8; j++){
                int[] positions = horseMove[j];

                indexRow = currentRow + positions[0];
                indexColl = currentColl + positions[1];

                if ((indexRow >= 0 && indexRow < n) && (indexColl >= 0 && indexColl < n)
                        && matrix[indexRow][indexColl] == 0){
                    matrix[indexRow][indexColl] = count;
                    count++;
                    currentRow = indexRow;
                    currentColl = indexColl;
                    canMove = true;
                    break;
                }
            }

            if (!canMove){
                for (int k = 0; k < matrix.length; k++){
                    boolean isBraked = false;

                    for (int l = 0; l < matrix[k].length ; l++){
                        if (matrix[k][l] == 0){
                            matrix[k][l] = count;
                            count++;
                            currentRow = k;
                            currentColl = l;
                            isBraked = true;
                            break;
                        }
                    }

                    if (isBraked){
                        break;
                    }

                }
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length - 1; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print(matrix[i][matrix[i].length - 1] + " ");
            System.out.println();
        }
    }
}
