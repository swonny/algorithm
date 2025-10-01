package 백준.cumulative_sum;

import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_19951 {

    public static void main(String[] args) throws IOException {
//        final String result = solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"});
        final String result = solution(	"99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});
//        final String result = solution("50:00:00", "50:00:00", new String[]{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"});

        System.out.println(result);
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        StringTokenizer st = new StringTokenizer(play_time, ":");
        int playTimeSec = Integer.parseInt(st.nextToken()) * 60 * 60 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(adv_time, ":");
        int advTimeSec = Integer.parseInt(st.nextToken()) * 60 * 60 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

        int[] tmp = new int[playTimeSec + 2];
        for (String l : logs) {
            StringTokenizer st2 = new StringTokenizer(l, "-");
            st = new StringTokenizer(st2.nextToken(), ":");
            int start = Integer.parseInt(st.nextToken()) * 60 * 60 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(st2.nextToken(), ":");
            int end = Integer.parseInt(st.nextToken()) * 60 * 60 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            tmp[start]++;
            tmp[end]--;
        }

        int[] cumSum = new int[playTimeSec + 2];
        cumSum[0] = tmp[0];
        for (int i = 1; i < playTimeSec + 2; i++) {
            cumSum[i] = cumSum[i - 1] + tmp[i];
        }

        for (int i = 1; i < playTimeSec + 2; i++) {
            cumSum[i] = cumSum[i - 1] + cumSum[i];
        }

        /*
        1. 처음 cumSum[0] ~ cumSum[advTimeSec] 시간과
        cumSum[advTimeSec+1] ~ cumSum[playTeimSec]까지 비교
        2. 슬라이딩 윈도우 기법으로 startIndex와 endIndex를 한개씩 옮기면서 maxSum을 구하기
         */
        long maxSum = cumSum[advTimeSec-1];
        long maxStart = 0;
        for (int i = advTimeSec; i < playTimeSec+2; i++) {
            int sum = cumSum[i] - cumSum[i - advTimeSec];
            if (sum > maxSum) {
                maxSum = sum;
                maxStart = i - advTimeSec + 1;
            }
        }

        System.out.println(formatTime(maxSum));
        String answer = formatTime(maxStart);
        return answer;
    }

    private static String formatTime(long seconds) {
        long h = seconds / 3600;
        seconds %= 3600;
        long m = seconds / 60;
        long s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
