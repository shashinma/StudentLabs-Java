public class Main {
    public static void main(String[] args) {
//        StringBuilder builder = new StringBuilder(args[0]);
        // Заменить все буквы "с" на "ч"
        String[] words = args[0].replace('с', 'ч').split("_");

        // Инвертировать первое слово
        StringBuilder builder = new StringBuilder(words[0]);
        words[0] = builder.reverse().toString();

        // Заменить первое слово на последовательность "%" той же длины
        words[0] = "%".repeat(words[0].length());

        // words[] -> StringBuilder builder
        builder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) builder.append(words[i]).append("_");
        builder.append(words[words.length - 1]);

        words = builder.toString().split("_");

        // Поменять местами седьмое и восьмое слово
        String tempString = words[6];
        words[6] = words[7];
        words[7] = tempString;

        // Привести восьмое слово к нижнему регистру (Дом -> дом)
        words[7] = words[7].toLowerCase();

        // words[] -> StringBuilder builder
        builder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) builder.append(words[i]).append("_");
        builder.append(words[words.length - 1]);

        System.out.println(builder);
    }
}

