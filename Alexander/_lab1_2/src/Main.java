public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        int[][][][] zones = new int[2][2][2][2];
        //[ниже линии?][в левом круге?][в правом круге?][в прямоугольнике?]
        zones[1][0][0][0] = 1;
        zones[1][0][1][0] = 2;
        zones[1][1][0][0] = 3;
        zones[1][1][1][0] = 4;
        zones[0][0][0][0] = 5;
        zones[0][1][0][0] = 6;
        zones[0][1][0][1] = 7;
        zones[1][1][0][1] = 8;
        zones[1][1][1][1] = 9;
        zones[1][0][1][1] = 10;
        zones[1][0][0][1] = 11;
        zones[0][0][0][1] = 12;

        System.out.println(zones
                [y < x + 2 ? 1 : 0] // Линия
                [Math.pow(x - 4, 2) + Math.pow(y - 5, 2) < Math.pow(4, 2) ? 1: 0] // Левый круг
                [Math.pow(x - 8, 2) + Math.pow(y - 4, 2) < Math.pow(4, 2) ? 1: 0] // Правый круг
                [(x < 11) && (x > 1) && (y > 4) && (y < 11) ? 1 : 0] // Правый прямоугольник
        );
    }
}