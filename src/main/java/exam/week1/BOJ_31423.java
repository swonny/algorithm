package exam.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_31423 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        String[] s = new String[N];
        String[] j = new String[N - 1];
        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }
        for (int i = 0; i < N -1; i++) {
            j[i] = br.readLine();
        }
    }
}
