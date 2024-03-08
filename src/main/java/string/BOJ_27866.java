package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_27866 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String string = br.readLine();
        final int i = Integer.parseInt(br.readLine());

        System.out.println(string.charAt(i - 1));
    }
}
