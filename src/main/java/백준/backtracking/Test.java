package 백준.backtracking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(List.of(1));

        a.add(0);
        a.remove(0);
        a.remove(1);

        var st = new StringTokenizer("a", "");
        st.nextToken();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.arraycopy(arr, 1, 4, 0, 3);

        String[] names = {"a", "b", "c", "d", "e", "f"};

        final List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        list.stream().toArray(Integer[]::new);

        Set<Map.Entry<String, Integer>> set = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sortedKeys = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer> comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey())
                )
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(LocalDate.parse("2025.12.20", DateTimeFormatter.ofPattern(".")));

        list.stream().collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        list.stream().collect(Collectors.toMap(name -> name, name -> 1, Integer::sum));

    }
}
