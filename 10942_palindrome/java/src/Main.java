import java.util.Scanner;

public class Main {

    //solve1. full search (timeout)
//    private static int isPalindrome(int S, int E, final int[] nums) {
//        int from = S - 1;
//        int to = E - 1;
//        while (from < to) {
//            if (nums[from] != nums[to]) {
//                return 0;
//            }
//            from++;
//            to--;
//        }
//        return 1;
//    }

    //solve2. dp

    static class Palindrome{
        int[] nums;
        boolean[][] palindromeTable;

        Palindrome(int[] nums){
            this.nums = nums;
            buildPalindromeTable();
        }

        void buildPalindromeTable() {
            this.palindromeTable = new boolean[nums.length][nums.length];
            for (int i = 0; i < nums.length; i++) {
                palindromeTable[i][i] = true;
            }
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    palindromeTable[i][i + 1] = true;
                }
            }

            for (int i = 2; i < nums.length; i++) {
                for (int j = 0; j < nums.length - i; j++) {
                    if (nums[j] == nums[j + i] && palindromeTable[j + 1][j + i - 1]) {
                        palindromeTable[j][j + i] = true;
                    }
                }
            }
        }
        int isPalindrome(int s, int e) {
            if (palindromeTable[s - 1][e - 1]) {
                return 1;
            }
            return 0;
        }
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        Palindrome palindrome = new Palindrome(nums);

        final int M = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            resultBuilder.append(palindrome.isPalindrome(s, e));
            resultBuilder.append("\n");
        }
        System.out.print(resultBuilder);
    }
}
