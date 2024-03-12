package 백준.two_dimentional_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2566 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int x = -1;
        int y = -1;
        for (int i = 0; i < 9; i++) {
            final String[] strings = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                final int num = Integer.parseInt(strings[j]);
                if (num > max) {
                    max = num;
                    x = j;
                    y = i;
                }
            }
        }

        System.out.println(max);
        System.out.println((y + 1) + " " + (x + 1));
    }
}
