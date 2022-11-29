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
//        StringBuilder builder = new StringBuilder(args[0]);
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

        // Привести нечётные слова к нижнему регистру
        builder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++){
            if (i % 2 != 0) {
                words[i] = words[i].toLowerCase();
            }
            builder.append(words[i]).append("_");
        }
        builder.append(words[words.length - 1]);

        // Повернуть восьмое слово циклически на 8 символов вправо
        builder = new StringBuilder(builder.toString().replace(words[7], words[7] = shiftString(words[7], 8)));

        System.out.println(builder);
    }
}

