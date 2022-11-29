import java.util.*;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> map = Map.of(
                "Cat", new ArrayList<>(List.of("Кот")),
                "Dog", new ArrayList<>(List.of("Собака")),
                "Green", new ArrayList<>(asList("Зелёный", "Зелень", "Трава")),
                "Table", new ArrayList<>(asList("Таблица", "Стол", "Доска", "Расписание")),
                "Window", new ArrayList<>(asList("Окно", "Витрина")));

        for (String key : map.keySet())
            if (map.get(key).contains(args[0]))
                System.out.println(key);
    }
}