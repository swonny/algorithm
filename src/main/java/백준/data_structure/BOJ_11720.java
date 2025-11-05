package 백준.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] numbers = br.readLine().toCharArray();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += numbers[i] - '0';
        }

        System.out.println(res);
    }
}
