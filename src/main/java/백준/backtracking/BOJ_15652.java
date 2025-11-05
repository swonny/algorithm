package 백준.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15652 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        dfs(new StringBuilder(), nums, m);

        bw.flush();
    }

    public static void dfs(StringBuilder num, int[] numbers, int m) throws IOException {
        if (num.length() == m * 2) {
            if (!num.toString().equals(prev)) {
                bw.write(num + "\n");
                prev = num.toString();
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (num.length() == 0 || (num.charAt(num.length() - 2) <= numbers[i] + '0')) {
                num.append(numbers[i]).append(" ");
                dfs(num, numbers, m);
                num.delete(num.length() - 2, num.length());
            }
        }
    }
}
