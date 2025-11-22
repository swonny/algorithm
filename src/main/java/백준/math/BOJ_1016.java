package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1016 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var min = Long.parseLong(st.nextToken());
        var max = Long.parseLong(st.nextToken());

        var check = new boolean[(int) (max - min + 1)];
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIndex = min / pow;
            if (min % pow != 0) startIndex++;
            for (long j = startIndex; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) count++;
        }

        System.out.println(count);
    }
}
