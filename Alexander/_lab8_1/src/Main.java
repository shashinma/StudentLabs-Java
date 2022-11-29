import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Записываем текст в StringBuilder
        StringBuilder builder = new StringBuilder();
        try(FileReader fr = new FileReader(args[0])){
            int x;
            while ((x = fr.read()) != -1)
                builder.append((char) x);
        }

        String result = builder.toString();

        /*
        Чередовать регистр символов текста посимвольно, начиная с символа с индексом 9 (считая с 0).
        Первый из символов в верхнем регистре (пробелы считаются за символы)
        */

        builder = new StringBuilder();

        char symbol;
        boolean regState = true;
        int i;

        for (i = 0; i < result.length(); i++) {
            symbol = result.charAt(i);
            if (i >= 5) {
                symbol = (regState) ? Character.toUpperCase(symbol) : Character.toLowerCase(symbol);
                regState = !regState;
            }
            builder.append(symbol);
        }

        /*
        Клонировать слова, если в них содержится символ 'е' в верхнем или нижнем регистре
        (Пример: символ 'в'. "Во_дворе_стоит_дом" => "ВоВо_дворедворе_стоит_дом")
        */

        String[] words = builder.toString().split("_");
        builder = new StringBuilder();

        for (i = 0; i < words.length; i++) {
            builder.append(words[i]);
            if (words[i].contains("в") || words[i].contains("В"))
                builder.append(words[i]);
            if (i != words.length - 1)
                builder.append("_");
        }

        // Записать результат в файл
        try(FileWriter fw = new FileWriter(args[1])){
            fw.write(builder.toString());
        }
    }
}
