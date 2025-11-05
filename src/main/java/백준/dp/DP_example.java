package 백준.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DP_example {
    static int[] D;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        D = new int[n + 1];
        Arrays.fill(D, -1);

        D[0] = 0;
        D[1] = 1;
//        fibo(n);
//        System.out.println(D[n]);

        System.out.println(test());
    }

    private static int test() {
        return D[1] = 1;
    }

    public static int fibo(int n) {
        if (D[n] != -1) {
            return D[n];
        }

        return D[n] = fibo(n - 2) + fibo(n - 1);
    }
}
