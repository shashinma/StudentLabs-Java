public class Main {
    public static void main(String[] args) {
        // Заменить все буквы "ю" на "х"
        String[] words = args[0].replace('ю', 'х').split("_");

        // Инвертировать первое слово
        StringBuilder builder = new StringBuilder(words[0]);
        words[0] = builder.reverse().toString(); //.deleteCharAt(1)

        // words[] -> StringBuilder builder
        builder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) builder.append(words[i]).append("_");
        builder.append(words[words.length - 1]);

        // Удалить символ с индексом 1
        builder.deleteCharAt(1);

        words = builder.toString().split("_");

        // Поменять местами шестое и четвёртое слово
        String tempString = words[5];
        words[5] = words[3];
        words[3] = tempString;

        // Заменить шестое слово на последовательность "%" той же длины
        words[5] = "%".repeat(words[5].length());

        builder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) builder.append(words[i]).append("_");
        builder.append(words[words.length - 1]);

        System.out.println(builder.toString());
    }
}