public class Main {
    public static void main(String[] args) {
        int print = 16;
        for (int i : new int[]{ 0, 1, 2, 3, 2, 1, 0 }) {
            int printed = 0;
            print -= 2;

            for (int j = 0; j < 6 - i * 2 && printed != print; j++, printed++) System.out.print(' ');
            for (int j = 0; j < 4 * i + 2 && printed != print; j++, printed++) System.out.print('*');
            for (int j = 0; j < 6 - i * 2 && printed != print; j++, printed++) System.out.print(' ');
            System.out.println();
        }
    }
}

