import java.util.*;

public class Main {
    public static void main (String[] args) {
        String key = args [0];
        Map<String, List<String>> map = Map.of(
                "Cat", new ArrayList<>(List.of("Кот")),
                "Green", new ArrayList<>(Arrays.asList("Зелёный", "Зелень", "Трава")),
                "Dog", new ArrayList<>(List.of("Собака")),
                "Table", new ArrayList<>(Arrays.asList("Таблица", "Стол", "Доска", "Расписание")),
                "House", new ArrayList<>(Arrays.asList("Дом", "Здание", "Строение")));
        if (map.containsKey(key))
            System.out.println(map.get (key).toString());
        else
            System.out.println("Error");
    }
}