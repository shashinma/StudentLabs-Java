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

        result = builder.toString();

        /*
        Чередовать регистр символов текста посимвольно, начиная с символа с индексом 6 (считая с 0).
        Первый из символов в верхнем регистре (пробелы считаются за символы)
        */

        builder = new StringBuilder();
        regState = false;

        for (i = 0; i < result.length(); i++) {
            symbol = result.charAt(i);
            if (i >= 6) {
                symbol = (regState) ? Character.toUpperCase(symbol) : Character.toLowerCase(symbol);
                regState = !regState;
            }
            builder.append(symbol);
        }

        // Записать результат в файл
        try(FileWriter fw = new FileWriter(args[1])){
            fw.write(builder.toString());
        }

        System.out.println(builder.toString());

    }
}

// С_другой_стороны_социально-экономическое_развитие_обеспечивает_актуальность_направлений_прогрессивного_развития._Значимость_этих_проблем_настолько_очевидна,...
// С_друГоЙ_СтОрОнЫ_СоЦиАлЬнО-ЭкОнОмИчЕсКоЕ_РаЗвИтИеРаЗвИтИе_оБеСпЕчИвАеТоБеСпЕчИвАеТ_АкТуАлЬнОсТь_нАпРаВлЕнИйНаПрАвЛеНиЙ_ПрОгРеСсИвНоГоПрОгРеСсИвНоГо_рАзВиТиЯ.РаЗвИтИя._ЗнАчИмОсТь_эТиХ_ПрОбЛеМ_НаСтОлЬкО_ОчЕвИдНа,...ОчЕвИдНа,...
// С_другОй_сТоРоНы_сОцИаЛьНо-эКоНоМиЧеСкОе_рАзВиТиЕ_ОбЕсПеЧиВаЕт_аКтУаЛьНоСтЬ_НаПрАвЛеНиЙ_ПрОгРеСсИвНоГо_рАзВиТиЯ._зНаЧиМоСтЬ_ЭтИх_пРоБлЕм_нАсТоЛьКо_оЧеВиДнА,...