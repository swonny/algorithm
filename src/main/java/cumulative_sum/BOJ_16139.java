package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16139 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String string = br.readLine();
        final int strLen = string.length();
        final int n = Integer.parseInt(br.readLine());

        Set<Character> keySet = new HashSet<>();
        Map<Character, int[]> cumSum = new HashMap<>();
        for (int i = 0; i < strLen; i++) {
            keySet.add(string.charAt(i));
        }

        for (char a : keySet) {
            final int[] ints = new int[strLen + 1];
            for (int i = 1; i < strLen + 1; i++) {
                int add = string.charAt(i - 1) == a ? 1 : 0;
                ints[i] = ints[i - 1] + add;
            }
            cumSum.put(a, ints);
        }

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final char q = st.nextToken().charAt(0);
            final int fromIdx = Integer.parseInt(st.nextToken());
            final int endIdx = Integer.parseInt(st.nextToken());
            int ans = 0;
            if (cumSum.containsKey(q)) {
                final int[] ints = cumSum.get(q);
                ans = ints[endIdx + 1] - ints[fromIdx];
            }
            result.append(ans).append(" \n");
        }

        System.out.println(result);
    }
}
