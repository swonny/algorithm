package 백준.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_12891 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String[] strings = br.readLine().split("");
        Map<String, Integer> indexes = new HashMap<>();
        indexes.put("A", 0);
        indexes.put("C", 1);
        indexes.put("G", 2);
        indexes.put("T", 3);
        int[] targetCounts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // init
        int checkSecret = 0;
        int answer = 0;
        int[] counts = new int[4];
        for (int i = 0; i < p; i++) {
            counts[indexes.get(strings[i])]++;
        }

        for (int i = 0; i < 4; i++) {
            if (counts[i] >= targetCounts[i]) checkSecret++;
        }

        if (checkSecret == 4) answer++;

        for (int left = 1, right = p; right < s; left++, right++) {
            counts[indexes.get(strings[left - 1])]--;
            counts[indexes.get(strings[right])]++;

            checkSecret = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] >= targetCounts[i]) {
                    checkSecret++;
                }
            }
            if (checkSecret == 4) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
