package cs.first_week;

import java.util.Random;

public class Question2 {

    public static void main(String[] args) {
        long t = System.currentTimeMillis(); // 현재 시간(밀리초)를 저장

        Long sum = 0L; // 래퍼 객체로 오토 박싱으로 정수 값을 저장

        // 백만번 도는 동안 더하기 연산
        for (long i = 0; i < 1000000; i++) {
            sum += i;
        }

        final Random random = new Random();
        random.nextLong();
        Integer.valueOf(1);
        System.out.println("processing time: " + (System.currentTimeMillis() - t) + " ms") ;

        String a = "hello";
        a.intern();
        String b = new String("hello");
    }
}
