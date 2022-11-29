public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);


        int[][][][] zones = new int[2][2][2][2];
        //[Ниже линии?][Круг][Прямоугольник 1][Прямоугольник 2]
        zones[1][0][0][0] = 1;
        zones[0][0][0][0] = 2;
        zones[1][0][0][1] = 3;
        zones[1][1][0][1] = 4;
        zones[0][0][0][1] = 5;
        zones[0][1][0][1] = 6;
        zones[0][1][0][0] = 7;
        zones[1][1][1][1] = 8;
        zones[0][1][1][1] = 9;
        zones[1][1][0][0] = 10;
        zones[0][1][1][0] = 11;
        zones[0][0][1][0] = 12;


        System.out.println(zones
                [y < -1 * x + 11 ? 1 : 0] // Линия
                [Math.pow(x - 7, 2) + Math.pow(y - 6, 2) < Math.pow(5, 2) ? 1: 0] // Круг
                [(x < 9) && (x > 3) && (y > 3) && (y < 11) ? 1 : 0] // Прямоугольник 1
                [(x < 10) && (x > 3) && (y > 1) && (y < 9) ? 1 : 0] // Прямоугольник 2
        );
    }
}

