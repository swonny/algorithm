package 백준.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int aSize = Integer.parseInt(st.nextToken());
            final int bSize = Integer.parseInt(st.nextToken());
            final String[] aTmp = br.readLine().split(" ");
            final String[] bTmp = br.readLine().split(" ");
            int count = 0;

            final int[] a = new int[aSize];
            final int[] b = new int[bSize];
            for (int i = 0; i < aSize; i++) {
                a[i] = Integer.parseInt(aTmp[i]);
            }
            for (int i = 0; i < bSize; i++) {
                b[i] = Integer.parseInt(bTmp[i]);
            }
            Arrays.sort(a);
            Arrays.sort(b);

            for (int i = 0; i < aSize; i++) {
                for (int j = 0; j < bSize; j++) {
                    if (a[i] <= b[j]) {
                        break;
                    }
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
