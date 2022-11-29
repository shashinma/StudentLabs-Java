public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);


        int[][][][] zones = new int[2][2][2][2];
        //[ниже линии?][в круге?][в левом прямоугольнике?][в правом прямоугольнике?]
        zones[1][0][0][0] = 1;
        zones[0][0][0][0] = 2;
        zones[1][0][0][1] = 3;
        zones[0][0][0][1] = 4;
        zones[1][0][1][0] = 5;
        zones[0][0][1][1] = 6;
        zones[0][0][1][0] = 7;
        zones[0][1][1][1] = 8;
        zones[0][1][0][1] = 9;
        zones[0][1][1][0] = 10;
        zones[0][1][0][0] = 11;

        System.out.println(zones
                [y < -1 * x + 8 ? 1 : 0] // Линия
                [Math.pow(x - 8, 2) + Math.pow(y - 8, 2) < Math.pow(3, 2) ? 1: 0] // Круг
                [(x < 9) && (x > 2) && (y > 3) && (y < 11) ? 1 : 0] // Левый прямоугольник
                [(x < 11) && (x > 4) && (y > 2) && (y < 8) ? 1 : 0] // Правый прямоугольник
        );
    }
}

// 5,5, 2,5
// 4
// 7