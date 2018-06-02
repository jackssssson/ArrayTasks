import java.util.Scanner;

public class BigNumbers {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String[] firstLine = in.nextLine().split(" ");
        String[] secondLine = in.nextLine().split(" ");
        String[] thirdLine = in.nextLine().split(" ");

        int firstLength = Integer.parseInt(firstLine[0]);
        int secondLength = Integer.parseInt(firstLine[1]);
        int biggerLength;

        int[] firstArray = new int[firstLength];
        int[] secondArray = new int[secondLength];

        for (int i = 0; i < firstLength; i++){
            firstArray[i] = Integer.parseInt(secondLine[i]);
        }

        for (int i = 0; i < secondLength; i++){
            secondArray[i] = Integer.parseInt(thirdLine[i]);
        }

        if (firstLength >= secondLength){
            biggerLength = firstLength;
        } else {
            biggerLength = secondLength;
        }

        int remainder = 0;

        for (int i = 0; i < biggerLength; i++){
            int firstNumber = 0;
            int secondNumber = 0;

            if (i < firstLength){
                firstNumber = firstArray[i];
            }

            if (i < secondLength){
                secondNumber = secondArray[i];
            }

            int result = firstNumber + secondNumber + remainder;
            int finalResult = result % 10;
            remainder = (result - finalResult) / 10;

            if (i < biggerLength - 1){
                System.out.print(finalResult + " ");
            } else {
                System.out.print(finalResult);
            }
        }
    }
}
