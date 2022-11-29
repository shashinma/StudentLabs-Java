public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        int[][][][] zones = new int[2][2][2][2];
        //[ниже горизонтальная линия?][ниже диагональной линии?][в круге?][в прямоугольнике?]
        zones[1][1][0][0] = 1;
        zones[1][1][1][0] = 2;
        zones[1][0][0][0] = 3;
        zones[1][1][0][1] = 4;
        zones[1][1][1][1] = 5;
        zones[0][0][0][0] = 6;
        zones[0][1][0][0] = 7;
        zones[0][1][0][1] = 8;
        zones[0][1][1][1] = 9;
        zones[0][1][1][0] = 10;
        zones[0][0][0][1] = 11;

        System.out.println(zones
                [y < 6 ? 1 : 0] // Горизонтальная линия
                [y < x + 4 ? 1 : 0] // Диагональная линия
                [Math.pow(x - 9, 2) + Math.pow(y - 6, 2) < Math.pow(3, 2) ? 1: 0] // Круг
                [(x < 10) && (x > 4) && (y > 4) && (y < 10) ? 1 : 0] // Прямоугольник
        );
    }
}