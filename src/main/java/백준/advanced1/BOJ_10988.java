package 백준.advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] strings = br.readLine().split("");

        int lastIdx = strings.length - 1;
        int ans = -(strings.length / 2);
        for (int i = 0; i < strings.length / 2; i++) {
            if (strings[i].equals(strings[lastIdx - i])) {
                ans++;
            }
        }

        System.out.println(ans == 0 ? 1 : 0);
    }
}
