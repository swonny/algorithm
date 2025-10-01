package 백준.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13423_2 {

    /**
     * 1. 배열 정렬
     * 2. Xi, Xi + 1을 두고 Xi + 2부터 끝까지 중에 절대값이 동일한 수가 있는지 확인, 있으면 반환
     * 3. 반복
     */
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            var N = Integer.parseInt(br.readLine());
            int result = 0;
            for (int n = 0; n < N; n++) {
                int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                Arrays.sort(arr);
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = i + 1; j < arr.length; j++) {
                        var dist = Math.abs(arr[i] - arr[j]);
                        var ret = binSearch(arr, j + 1, arr.length - 1, arr[j] + dist);
                        result += ret > -1 ? 1 : 0;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static int binSearch(int[] arr, int l, int r, int target) {
        int mid;

        System.out.println("binSearch() : " + Arrays.toString(arr));
        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                l = mid + 1;
            } else if (target < arr[mid]){
                r = mid - 1;
            }
        }

        return -1;
    }
}
