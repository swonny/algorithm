package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_3052 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> remains = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            remains.add(Integer.parseInt(br.readLine()) % 42);
        }

        System.out.println(remains.size());
    }
}
