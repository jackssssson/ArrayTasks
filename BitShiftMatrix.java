import java.math.BigInteger;
import java.util.Scanner;

public class BitShiftMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int R = in.nextInt();
        int C = in.nextInt();
        int N = in.nextInt();
        int[] cells = new int[N];

        for (int i = 0; i < N; i++) {
            cells[i] = in.nextInt();
        }

        BigInteger[] powsTwo = new BigInteger[R + C + 1];
        BigInteger powTwo = BigInteger.ONE;

        for (int i = 0; i < R + C - 1; i++){
            powsTwo[i] = powTwo;
            powTwo = powTwo.multiply(BigInteger.valueOf(2));
        }

        boolean[][] matrix = new boolean[R][C];
        int coef = Math.max(R, C);
        int currentR = R - 1;
        int currentC = 0;
        BigInteger result = BigInteger.valueOf(0);

        for (int cell : cells){
            int targetRow = cell / coef;
            int targetColl = cell % coef;



            int horizontalDir;

            if (currentC <= targetColl){
                horizontalDir = 1;
            } else {
                horizontalDir = -1;
            }

            int verticalDir;
            if (currentR <= targetRow){
                verticalDir = 1;
            } else {
                verticalDir = -1;
            }
            while(currentC != targetColl || currentR != targetRow){
                if (!matrix[currentR][currentC]){
                    matrix[currentR][currentC] = true;
                    int pow = R - currentR + currentC - 1;
                    result = result.add(powsTwo[pow]);
                }

                if (currentC != targetColl){
                    currentC += horizontalDir;
                    continue;
                }

                if (currentR != targetRow){
                    currentR += verticalDir;
                }
            }
        }

        if (!matrix[currentR][currentC]){
            matrix[currentR][currentC] = true;
            int pow = R - currentR + currentC - 1;
            result = result.add(powsTwo[pow]);
        }

        System.out.println(result);
    }
}
