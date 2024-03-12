package 백준.two_dimentional_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798 {


    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] first = br.readLine().split("");
        int cols = first.length;

        String[][] strings = new String[5][cols];
        strings[0] = first;
        for (int i = 1; i < 5; i++) {
            strings[i] = br.readLine().split("");
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(i < strings[j].length ? strings[j][i] : "");
            }
        }
    }
}
