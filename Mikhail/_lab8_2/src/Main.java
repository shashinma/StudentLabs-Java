import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static StringBuilder changeReg(StringBuilder builder, boolean regState, int poseIndex){
        int i;
        StringBuilder result = new StringBuilder();
        char symbol;

        for (i = 0; i < builder.length(); i++) {
            symbol = builder.charAt(i);
            if (i >= poseIndex) {
                symbol = (regState) ? Character.toUpperCase(symbol) : Character.toLowerCase(symbol);
                regState = !regState;
            }
            result.append(symbol);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        // Записываем текст в StringBuilder
        StringBuilder builder = new StringBuilder();
        try(FileReader fr = new FileReader(args[0])){
            int x;
            while ((x = fr.read()) != -1)
                builder.append((char) x);
        }

        /*
        Чередовать регистр символов текста посимвольно, начиная с символа с индексом 9 (считая с 0).
        Первый из символов в верхнем регистре (пробелы считаются за символы)
         */

        builder = changeReg(builder, false, 9);

        /*
        Инвертировать весь текст (Дом_стоит_во_дворе => еровд_ов_тиотс_моД)
         */

        builder.reverse();

        /*
        Чередовать регистр символов текста посимвольно, начиная с символа с индексом 9 (считая с 0).
        Первый из символов в верхнем регистре (пробелы считаются за символы)
         */

        builder = changeReg(builder, true, 8);

        // Записать результат в файл
        try(FileWriter fw = new FileWriter(args[1])){
            fw.write(builder.toString());
        }
    }
}