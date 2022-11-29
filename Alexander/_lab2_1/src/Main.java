public class Main {
    public static void main(String[] args) {
        for (int i : new int[]{4, 3, 2, 1, 0}) {
            for (int j = 0; j < 8 - i * 2; j++) System.out.print(' ');
            for (int j = 0; j < 2 * i + 1; j++) System.out.print('*');
            System.out.println();
        }
    }
}