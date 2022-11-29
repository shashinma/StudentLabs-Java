import java.util.*;

public class Main {
    public static void main (String[] args) {
        String key = args [0];
        Map<String, List<String>> map = Map.of(
                "Cat", new ArrayList<>(List.of("Кот")),
                "Dog", new ArrayList<>(List.of("Собака")),
                "Green", new ArrayList<>(Arrays.asList("Зелёный", "Зелень", "Трава")),
                "Table", new ArrayList<>(Arrays.asList("Таблица", "Стол", "Доска", "Расписание")),
                "Window", new ArrayList<>(Arrays.asList("Окно", "Витрина")));
        if (map.containsKey(key))
            System.out.println(map.get (key).toString());
        else
            System.out.println("Error");
    }
}