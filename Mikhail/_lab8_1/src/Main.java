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

        String sourceString = builder.toString();

        /*
        Чередовать регистр символов текста посимвольно, начиная с символа с индексом 8 (считая с 0).
        Первый из символов в верхнем регистре (пробелы считаются за символы)
        */

        builder = new StringBuilder();

        int i;
        char symbol;
        boolean regState = true;

        for (i = 0; i < sourceString.length(); i++) {
            symbol = sourceString.charAt(i);
            if (i >= 8) {
                symbol = (regState) ? Character.toUpperCase(symbol) : Character.toLowerCase(symbol);
                regState = !regState;
            }
            builder.append(symbol);
        }

        builder.reverse();

        // Записать результат в файл
        try(FileWriter fw = new FileWriter(args[1])){
            fw.write(builder.toString());
        }
    }
}
