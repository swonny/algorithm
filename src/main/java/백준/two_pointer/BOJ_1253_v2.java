package 백준.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1253_v2 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                var tmp = numbers[left] + numbers[right];
                if (tmp > numbers[i]) {
                    right--;
                } else if (tmp < numbers[i]) {
                    left++;
                } else if (tmp == numbers[i]){
                    if (i != left & i != right) {
                        answers.add(numbers[i]);
                        break;
                    } else if (i == left) {
                        left++;
                    } else if (i == right) {
                        right--;
                    }
                }
            }
        }

        System.out.println(answers.size());
    }
}
