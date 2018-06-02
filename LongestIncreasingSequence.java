import java.util.Scanner;

public class LongestIncreasingSequence {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] numbers = new int[N];
        int sequence = 1;
        int bestSequence = 1;

        for (int i = 0; i < N; i++){
            numbers[i] = in.nextInt();
        }

        for (int i = 0; i < N - 1; i++){
            if (numbers[i] < numbers[i + 1]){
                sequence++;

                if (bestSequence < sequence){
                    bestSequence = sequence;
                }
            }
            else{
                sequence = 1;
            }
        }

        System.out.println(bestSequence);
    }
}
