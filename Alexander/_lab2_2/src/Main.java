public class Main {
    public static void main(String[] args) {
        for (int i : new int[]{3, 2, 1, 0}) {
            for (int j = 0; j < 6 - i * 2 && i != 0; j++) System.out.print('#');
            for (int j = 0; j < 4 * i - 3; j++) System.out.print('*');

            System.out.println();
        }
    }
}