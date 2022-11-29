public class Main {
    public static String shiftString(String inputString, int shiftModifier) {
        StringBuilder sourceString = new StringBuilder(inputString);
        String subString;
        for (int i = 0; i < shiftModifier; i++) {
            subString = sourceString.substring(sourceString.length() - 1);
            sourceString = new StringBuilder(subString + sourceString.delete(sourceString.length() - 1,
                    sourceString.length()));
        }
        return sourceString.toString();
    }

    public static void main(String[] args) {
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

        // Привести нечётные слова к нижнему регистру
        builder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++){
            if (i % 2 != 0) {
                words[i] = words[i].toUpperCase();
            }
            builder.append(words[i]).append("_");
        }
        builder.append(words[words.length - 1]);

        builder = new StringBuilder(builder.toString().replace(words[1], words[1] = shiftString(words[1], 7)));

        System.out.println(builder);
    }
}