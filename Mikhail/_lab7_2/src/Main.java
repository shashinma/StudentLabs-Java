import java.util.*;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> map = Map.of(
                "Cat", new ArrayList<>(List.of("Кот")),
                "Green", new ArrayList<>(Arrays.asList("Зелёный", "Зелень", "Трава")),
                "Dog", new ArrayList<>(List.of("Собака")),
                "Window", new ArrayList<>(Arrays.asList("Окно", "Витрина")),
                "House", new ArrayList<>(Arrays.asList("Дом", "Здание", "Строение")));

        for (String key : map.keySet())
            if (map.get(key).contains(args[0]))
                System.out.println(key);
    }
}