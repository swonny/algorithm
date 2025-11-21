package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1747 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        var primes = new int[1_000_001];
        for (int i = 2; i <= 1_000_000; i++) {
            primes[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(1_000_000); i++) {
            if (primes[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= 1_000_000; j += i) {
                primes[j] = 0;
            }
        }

        for (int i = n; i < primes.length; i++) {
            if (primes[i] != 0) {
                if (isPalindrome(i)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }

    private static boolean isPalindrome(int number) {
        var num = String.valueOf(number).toCharArray();
        for (int i = 0; i < num.length / 2; i++) {
            if (num[num.length - i - 1] != num[i]) {
                return false;
            }
        }

        return true;
    }
}
