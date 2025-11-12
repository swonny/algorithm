package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var raw = br.readLine();
        var isFirstPositive = raw.charAt(0) == '+';

        var numbers = raw.split("-");

        var sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            var st = new StringTokenizer(numbers[i], "+");
            var subtract = 0;
            while (st.hasMoreTokens()) {
                subtract += Integer.parseInt(st.nextToken());
            }
            if (i == 0 && !isFirstPositive) sum += subtract;
            else sum -= subtract;
        }
        System.out.println(sum);
    }
}
