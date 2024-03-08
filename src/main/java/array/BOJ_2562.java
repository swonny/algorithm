package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2562 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = new ArrayList<>();
        int max = -1;
        int maxIdx = -1;
        for (int i = 1; i <= 9; i++) {
            final int curNum = Integer.parseInt(br.readLine());
            if (curNum > max) {
                max = curNum;
                maxIdx = i;
            }
        }

        System.out.println(max);
        System.out.println(maxIdx);
    }
}
