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

        String result = builder.reverse().toString();



        /*
        Чередовать регистр символов текста посимвольно, начиная с символа с индексом 9 (считая с 0).
        Первый из символов в верхнем регистре (пробелы считаются за символы)
        */

        builder = new StringBuilder();

        char symbol;
        boolean regState = false;
        int i;

        for (i = 0; i < result.length(); i++) {
            symbol = result.charAt(i);
            if (i >= 0) {
                symbol = (regState) ? Character.toUpperCase(symbol) : Character.toLowerCase(symbol);
                regState = !regState;
            }
            builder.append(symbol);
        }

        /*
        Клонировать слова, если в них содержится символ 'ю' в верхнем или нижнем регистре
        (Пример: символ 'в'. "Во_дворе_стоит_дом" => "ВоВо_дворедворе_стоит_дом")
        */

        String[] words = builder.toString().split("_");
        builder = new StringBuilder();

        for (i = 0; i < words.length; i++) {
            builder.append(words[i]);
            if (words[i].contains("ю") || words[i].contains("Ю"))
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

// Повседневная_практика_показывает,_что_рамки_и_место_обучения_кадров_способствует_подготовке_и_реализации_соответствующих_условий..."
// О: ...ЙиВоЛсУ_ХиЩюУвТсТеВтОоСХиЩюУвТсТеВтОоС_ИиЦаЗиЛаЕр_и_еКвОтОгДоП_ТеУвТсБоСоПс_вОрДаК_ЯиНеЧуБо_оТсЕм_и_иКмАр_оТч_,ТеАвЫзАкОп_аКиТкАрП_ЯаНвЕнДеСвОп
// В: ПовсеДнЕвНаЯпОвСеДнЕвНаЯ_ПрАкТиКа_пОкАзЫвАеТ,ПоКаЗыВаЕт,_ЧтО_РаМкИ_И_МеСтО_ОбУчЕнИя_кАдРоВкАдРоВ_СпОсОбСтВуЕтСпОсОбСтВуЕт_пОдГоТоВкЕпОдГоТоВкЕ_И_РеАлИзАцИи_сОоТвЕтСтВуЮщИхСоОтВеТсТвУюЩиХ_УсЛоВиЙ...УсЛоВиЙ...
