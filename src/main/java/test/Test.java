package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        정수_리스트_정렬();
        문자열_리스트_정렬();

        Map<String, Integer> a = new HashMap<>();
        a.put("a", 1);
        a.put("b", 2);

        a.entrySet()
         .stream()
         .sorted(Map.Entry.comparingByValue())
         .sorted(Map.Entry.<String, Integer> comparingByValue().thenComparing(Map.Entry.comparingByKey()))
         .map(Map.Entry::getKey)
         .collect(Collectors.toList());
    }

    public static void 정수_리스트_정렬() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 10, 9, 8, 7, 6, 5);
        list.sort(Comparator.comparingInt(a -> a));

        System.out.println(list);
    }

    public static void 문자열_리스트_정렬() {
        List<String> list = Arrays.asList("hello", "my", "name", "is", "seugnwon");
        list.sort(Comparator.comparing(a -> a));
        Collections.sort(list, Comparator.comparing(a -> a));

        int[] a = {1, 2, 3, 4};
        Arrays.asList(a);

        System.out.println(list);
    }

    public static void 맵_정렬() {
        Map<String, Integer> map = new HashMap<>();
        map.put("ABC", 1);
        map.put("ABC", 2);
        map.put("DEF", 1);
        map.put("DEF", 2);

        // value 기준 정렬
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // key 기준 정렬
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public class 객체_정렬 {
        public void 정렬() {
            List<Person> people = Arrays.asList(new Person("a", 10), new Person("a", 20), new Person("b", 10), new Person("b", 20));
            people.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));

            System.out.println(people);
        }
    }

    public class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String getName() {
            return name;
        }

        private int getAge() {
            return age;
        }
    }
}
