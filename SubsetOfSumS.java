import java.util.Scanner;

public class SubsetOfSumS {
    public static boolean subSetDP(int[] A, int sum) {
        boolean[][] solution = new boolean[A.length + 1][sum + 1];
        // if sum is not zero and subset is 0, we can't make it
        for(int i=1;i<=sum;i++){
            solution[0][i]=false;
        }
        // if sum is 0 then we can make the empty subset to make sum 0
        for(int i=0;i<=A.length;i++){
            solution[i][0]=true;
        }
        //
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=sum;j++){
                //first copy the data from the top
                solution[i][j] = solution[i-1][j];

                //If solution[i][j]==false check if can be made
                if(solution[i][j]==false && j>=A[i-1])
                    solution[i][j] = solution[i][j] || solution[i-1][j-A[i-1]];
            }
        }
        return solution[A.length][sum];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int S = in.nextInt();
        in.nextLine();
        String[] input = in.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numbers[i] = Integer.parseInt(input[i]);
        }

        boolean subSetSum = subSetDP(numbers, S);

        if (subSetSum){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
