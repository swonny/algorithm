package 백준.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class BOJ_12891_v3 {
    private static final Map<Character, Integer> INDEX = Map.of('A', 0, 'C', 1, 'G', 2, 'T', 3);

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var lengths = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var string = br.readLine().toCharArray();

        var targetCount = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] target = new int[4];
        for (int i = 0; i < 4; i++) {
            target[i] = targetCount[i];
        }


        int[] count = new int[5];
        for (int i = 0; i < lengths[1]; i++) {
            int idx = INDEX.getOrDefault(string[i], 4);
            count[idx]++;
        }
        int answer = 0;
        if (dna(count, target)) answer++;

        for (int i = 1; i <= lengths[0] - lengths[1]; i++) {
            int toDelete = INDEX.getOrDefault(string[i - 1], 4);
            int toAdd = INDEX.getOrDefault(string[i + lengths[1] - 1], 4);
            count[toDelete]--;
            count[toAdd]++;
            if (dna(count, target)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean dna(int[] count, int[] target) {
        for (int i = 0; i < 4; i++) {
            if (count[i] < target[i]) return false;
        }

        return true;
    }
}
