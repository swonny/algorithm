package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int count = 1;
        int number = 666;

        while (count != N) {
            number++;
            if (Integer.toString(number).contains("666")) {
                count++;
            }
        }
        System.out.println(number);
    }
}
