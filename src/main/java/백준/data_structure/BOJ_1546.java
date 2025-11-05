package 백준.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        var n = Integer.parseInt(br.readLine());
        var scores = Arrays.stream(br.readLine().split(" ")).filter(it -> !it.isBlank()).mapToInt(Integer::parseInt).toArray();

        int max = scores[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(scores[i], max);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += scores[i];
        }

        System.out.println(Double.toString(res * 100 / max / n));
    }
}
