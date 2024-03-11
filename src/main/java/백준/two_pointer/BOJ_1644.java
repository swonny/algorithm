package 백준.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1644 {

    private static boolean[] primeBool;	// 소수를 체크할 배열

    public static void main(String[] args) throws IOException {
        final int[] primeNums = make_prime(8_000_000).stream()
                .mapToInt(Integer::intValue)
                .toArray();

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(stringTokenizer.nextToken());

        int left = 0;
        int right = 0;
        int sum = primeNums[left];
        int count = 0;
        while (primeNums[left] <= n) {
            if (sum == n) {
                count++;
                sum -= primeNums[left];
                left++;
                right++;
                sum += primeNums[right];
            } else if (sum > n) {
                sum -= primeNums[left];
                left++;
            } else {
                right++;
                sum += primeNums[right];
            }
        }

        System.out.println(count);
    }

    // N 이하 소수 생성 메소드
    public static List<Integer> make_prime(int N) {

        primeBool = new boolean[N + 1];	// 0 ~ N
        final List<Integer> primeNums = new ArrayList<>();

		/*
		소수가 아닌 index = true
		소수인 index = false
		*/

        // 2 미만의 N 을 입력받으면 소수는 판별할 필요 없으므로 바로 return
        if(N < 2) {
            primeNums.add(N);
            return primeNums;
        }

        primeBool[0] = primeBool[1] = true;


        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(N); i++) {

            // 이미 체크된 배열이면 다음 반복문으로 skip
            if(primeBool[i] == true) {
                continue;
            }

            // i 의 배수들을 걸러주기 위한 반복문
            for(int j = i * i; j < primeBool.length; j = j+i) {
                primeBool[j] = true;
            }
        }

        for(int i = 0; i < primeBool.length; i++) {
            if(primeBool[i] == false) {	// 소수(false)일 경우 출력
                primeNums.add(i);
            }
        }

        return primeNums;
    }
}
