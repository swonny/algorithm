package 백준.cumulative_sum;

import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_19951_V2 {

    public static void main(String[] args) throws IOException {
        final String result = solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"});
//        final String result = solution("99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});

        System.out.println("result: " + result);
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        /*
         * 1. play_time 배열 생성
         * 2. logs에 해당하는 시간 cumulativeSum 구하기
         * 3. adv_time을 초 단위로 구하기
         *
         * 4. advTimeSec 시작 시간 ~ advTimeSec 종료 시간 cumSum으로 max값 구하고
         * 5. max값 업데이트 시 시간도 업데이트
         * */
        StringTokenizer st = new StringTokenizer(play_time, ":");
        final int playTimeSec = Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        // 00초를 포함하니까
        int[] tmp = new int[playTimeSec + 2];
        for (String log : logs) {
            StringTokenizer st1 = new StringTokenizer(log, "-");
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), ":"); // 시작 시간
            final int start = Integer.parseInt(st2.nextToken()) * 3600 + Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
            st2 = new StringTokenizer(st1.nextToken(), ":"); // 시작 시간
            final int end = Integer.parseInt(st2.nextToken()) * 3600 + Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
            System.out.println("start: " +start + " end: " + end);

            tmp[start]++;
            tmp[end+1]--;
        }

        int[] cumSum = new int[playTimeSec + 2];
        for (int i = 1; i < cumSum.length; i++) {
            cumSum[i] = cumSum[i - 1] + tmp[i];
        }

        st = new StringTokenizer(adv_time, ":");
        int advTimeSec = Integer.parseInt(st.nextToken()) *3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        /**
         * 누적 재생 시간
         * 그 시간의 합이 가장 큰 시간을 구하면 되고, 시간을 구해서 그 사이 합을 구하면 됨
         */
        for (int i = 1; i < cumSum.length; i++) {
            cumSum[i] = cumSum[i - 1] + cumSum[i];
        }

        for (String log : logs) {
            StringTokenizer st1 = new StringTokenizer(log, "-");
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), ":"); // 시작 시간
            final int start = Integer.parseInt(st2.nextToken()) * 3600 + Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
            st2 = new StringTokenizer(st1.nextToken(), ":"); // 시작 시간
            final int end = Integer.parseInt(st2.nextToken()) * 3600 + Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());

            final int tmpRes = cumSum[end] - cumSum[start-1];
            System.out.println("[" + start + "] - [" +end +"]: " + tmpRes);
            System.out.println();
        }

        int maxStart = 0;
        int max = 0;
        for (int i = advTimeSec-1; i < cumSum.length-1; i++) {
            if (i >= advTimeSec)
                max = Math.max(max, cumSum[i] - cumSum[i - advTimeSec]);
            else
                max = Math.max(max, cumSum[i]);
        }
        System.out.println(cumSum[3599]);

        System.out.println(3599/60);

        /**
         *   1 1 1 0 2 2 2 1 1 1
         *   1 2 3 3 5 7 9 10 11 12
         * 0 1 2 3 4 5 6 7 8 9 10
         *
         */
        // maxStart ~ maxStart+advTimeSec
        int res = max;
        System.out.println(res / 3600);
        String hh = String.format("%02d", res / 3600) + ":";
        res = res % 3600;
        String mm = String.format("%02d", res / 60) + ":";
        res = res % 60;
        String ss = String.format("%02d", res);
        return hh + mm + ss;
    }
}
