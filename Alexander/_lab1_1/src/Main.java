public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);


        int[][][] zones = new int[2][2][2];
        //[ниже линии?][в круге?][в прямоугольнике?]
        zones[1][0][0] = 1;
        zones[1][1][0] = 2;
        zones[0][0][0] = 3;
        zones[0][0][1] = 4;
        zones[1][1][1] = 5;
        zones[0][1][1] = 6;
        zones[1][0][1] = 7;

        System.out.println(zones
                [y < x + 1 ? 1 : 0] // Линия
                [Math.pow(x - 8, 2) + Math.pow(y - 4, 2) < Math.pow(4, 2) ? 1: 0] // Круг
                [(x < 11) && (x > 1) && (y > 4) && (y < 11) ? 1 : 0] // Правый прямоугольник
        );
    }
}