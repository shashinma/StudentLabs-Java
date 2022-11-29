public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);


        int[][][] zones = new int[2][2][2];
        //[ниже линии?][в круге?][в прямоугольнике?]
        zones[1][0][0] = 1;
        zones[0][0][0] = 2;
        zones[0][0][1] = 3;
        zones[0][1][1] = 4;
        zones[0][1][0] = 5;

        System.out.println(zones
                [y < -1 * x + 7 ? 1 : 0] // Линия
                [Math.pow(x - 6, 2) + Math.pow(y - 7, 2) < Math.pow(4, 2) ? 1: 0] // Круг
                [(x < 10) && (x > 4) && (y > 2) && (y < 9) ? 1 : 0] // Правый прямоугольник
        );
    }
}