import java.util.*;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> map = Map.of(
                "Dog", new ArrayList<>(List.of("Собака")),
                "House", new ArrayList<>(Arrays.asList("Дом", "Здание", "Строение")),
                "Green", new ArrayList<>(asList("Зелёный", "Зелень", "Трава")),
                "Table", new ArrayList<>(asList("Таблица", "Стол", "Доска", "Расписание")),
                "Window", new ArrayList<>(asList("Окно", "Витрина")));

        for (String key : map.keySet())
            if (map.get(key).contains(args[0]))
                System.out.println(key);
    }
}