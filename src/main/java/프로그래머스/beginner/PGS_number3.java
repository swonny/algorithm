import java.util.*;

class PGS_number3 {
    public int solution(int n) {
        int answer = 0;

        int num = 1;
        List<Integer> answers = new ArrayList<>();
        while (answers.size() <= 100) {
            if (num % 3 != 0 && !String.valueOf(num).contains("3")) {
                answers.add(num);
            }
            num++;
        }

        return answers.get(n - 1);
    }
}
