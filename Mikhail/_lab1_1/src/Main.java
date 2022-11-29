public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);


        int[][][] zones = new int[2][2][2];
        zones[1][0][0] = 1;
        zones[0][0][0] = 2;
        zones[1][1][0] = 3;
        zones[0][1][0] = 4;
        zones[1][1][1] = 5;
        zones[0][1][1] = 6;
        zones[1][0][1] = 7;

        System.out.println(zones
                [y < x + 1 ? 1 : 0]
                [Math.pow(x - 6, 2) + Math.pow(y - 6, 2) < Math.pow(5, 2) ? 1: 0]
                [(x < 11) && (x > 4) && (y > 4) && (y < 10) ? 1 : 0]
        );
    }
}