package bocho_study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {
        Object[][] example = {{"A", 10, 3}, {"B", 20, 4}, {"C", 15, 5}};
        // Object[][] example = {{"YJJ", 100, 17}, {"PYS", 20, 20}};
        // Object[][] example = {{"B", 10, 3}, {"A", 10, 3}, {"BB", 10, 3}, {"AA", 10, 3}};
        solution(example);
    }

    /**
     * 학생별 이긴 횟수 구해서 저장
     * 이긴 횟수 많은 순서로 정렬
     * 이긴 횟수가 동일할 경우 사전 역순으로 정렬
     */
    public static void solution(Object[][] specs) {
        // 이름, 이긴 게임 횟수
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < specs.length; i++) res.put((String) specs[i][0], 0);

        for (int i = 0; i < specs.length; i++) {
            var name = (String) specs[i][0];
            var power = (Integer) specs[i][1];
            var supplement = (Integer) specs[i][2];
            if (i == specs.length - 1) break;
            for (int j = i + 1; j < specs.length; j++) {
                var n = (String) specs[j][0];
                var p = (Integer) specs[j][1];
                var s = (Integer) specs[j][2];

                var a = power + (supplement * p);
                var b = p + (s * power);
                if (a > b) res.put(name, res.get(name) + 1);
                if (a < b) res.put(n, res.get(n) + 1);
            }
        }

        var result = res.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.<String, Integer>comparingByKey().reversed()))
                .map(e -> e.getKey())
                .toArray();

        System.out.println(Arrays.toString(result));
    }
}
