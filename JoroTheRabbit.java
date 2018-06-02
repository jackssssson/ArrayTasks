import java.util.Scanner;

public class JoroTheRabbit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(", ");
        int[] numbers = new int[input.length];
        int bestLength = 0;

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < numbers.length; i++){
            int currentLength = 0;
            int step = 1;
            int countStep = 1;
            int currentIndex = i;

            while (true){
                int position = currentIndex + step;

                if (position >= numbers.length){
                    while (position >= numbers.length){
                        position -= numbers.length;
                    }
                }

                int firstNumber = numbers[currentIndex];
                int secondNumber = numbers[position];

                if (firstNumber < secondNumber){
                    currentLength++;
                    currentIndex += step;

                    if (currentIndex >= numbers.length){
                        while (currentIndex >= numbers.length){
                            currentIndex -= numbers.length;
                        }
                    }

                    if (bestLength < currentLength){
                        bestLength = currentLength;
                    }
                } else {
                    countStep++;
                    currentIndex = i;
                    step = countStep;
                    currentLength = 0;

                    if (step >= numbers.length){
                        break;
                    }
                }
            }
        }

        bestLength++;
        System.out.println(bestLength);
    }
}
