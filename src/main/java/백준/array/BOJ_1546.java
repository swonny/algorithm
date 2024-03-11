package 백준.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());

        float max = -1;
        float[] scores = new float[N];
        int i = 0;
        while (st.hasMoreTokens()) {
            final float num = Float.parseFloat(st.nextToken());
            scores[i++] = num;
            max = Math.max(max, num);
        }

        float sum = 0;
        for (int j = 0; j < N; j++) {
            sum += scores[j] / max * 100;
        }

        System.out.print(sum / N);
    }
}
