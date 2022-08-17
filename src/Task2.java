import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        /**
         * #1
         * */
        decomposition();

    }

    static int[] a = new int[100];

    static void decomposition() {
        int i;
        int j;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter: ");
        int m = scanner.nextInt();
        for (i = 0; i <= m; i++) {
            a[i] = 0;
        }
        System.out.println("Result: ");
        dec(m, m, 0);
    }

    static void dec(int n, int k, int i) {
        if (n < 0) return;
        if (n == 0) {

            int j;
            for (j = 0; j < i; j++) {
                System.out.print(a[j] + " ");
                ;
            }
            System.out.println();
            ;
        } else {
            if (n - k >= 0) {
                a[i] = k;
                dec(n - k, k, i + 1);
            }

            if (k - 1 > 0) {
                dec(n, k - 1, i);
            }
        }
    }
}
