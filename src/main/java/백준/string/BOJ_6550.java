package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6550 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input == null) break;

            final String[] strings = input.split(" ");

            int count = 0;
            int j = 0;
            for (int i = 0; i < strings[1].length(); i++) {
                if (strings[1].charAt(i) == strings[0].charAt(j)) {
                    j++;
                    count++;
                    if (j == strings[0].length()) break;
                }
            }
            System.out.println(count == strings[0].length() ? "YES" : "NO");
        }
    }
}
