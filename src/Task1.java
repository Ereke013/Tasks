import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        /**
         * #1
         * */
//        String nums = "00101110000110";
//        zeros(nums);

        /**
         * #2
         * */
//        String arrows = "<<<<>>--><--<<--<<>>>--><<<<<";
//        arrows(arrows);

        /**
         * #3
         * */
//        String str = "abababa";
//        strLoop(str);

        /**
         * #4
         * */

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter count of numbers: ");
//        int count = scanner.nextInt();
//        int[] nums = new int[count];
//
//        System.out.print("Enter numbers: ");
//        for(int i = 0; i < count; i++) {
//            nums[i] = scanner.nextInt();
//        }
//
//        homeWork(nums);

        /**
         * #5
         * */
        hairSolution();

    }

    static void zeros(String numbers) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < numbers.length(); ++i) {
            if (numbers.charAt(i) == '0')
                maxCount += 1;
            else {
                if (count < maxCount)
                    count = maxCount;
                maxCount = 0;
            }
        }
        if (count < maxCount)
            count = maxCount;
        System.out.println(count);
    }

    static void arrows(String arrows) {
        String str;
        int count = 0;

        for (int i = 0; i <= arrows.length() - 5; i++) {
            str = arrows.substring(i, i + 5);
            if (str.equals(">>-->") || str.equals("<--<<"))
                count++;
        }
        System.out.println(count);
    }

    static void strLoop(String str) {
        int count = 0;
        int t = 1;
        String s = String.valueOf(str.charAt(0));

        for (int i = 1; i <= str.length(); ) {
            if (i + t > str.length()) {
                break;
            }

            String z = str.substring(i, i + t);

            if (s.equals(z)) {
                count++;
                i += t;
            } else {
                s += z;
                t++;
                i++;
            }
        }

        System.out.println(count);
    }

    static void homeWork(int[] numbers) {

        int indexOfMax = 0;
        int indexOfMin = 0;

        int advNums = 0;

        for (int i = 0; i < numbers.length; i++) {
            indexOfMax = numbers[i] > numbers[indexOfMax] ? i : indexOfMax;
            indexOfMin = numbers[i] < numbers[indexOfMin] ? i : indexOfMin;

            if (numbers[i] > 0) {
                advNums += numbers[i];
            }
        }

        int startIndex = Math.min(indexOfMax, indexOfMin);
        int finishIndex = Math.max(indexOfMax, indexOfMin);

        int multipleNumbers = 1;

        for (int i = startIndex + 1; i < finishIndex; i++) {
            multipleNumbers *= numbers[i];
        }

        System.out.println(advNums + " " + multipleNumbers);
    }

    static void hairSolution() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter count: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Numbers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = arr[0];
        int cd = 0;
        int d = -1;
        int sum = 0;

        while (cd < n) {
            for (int z = cd + 1; z < n; z++) {
                if (arr[z] > max) {
                    max = arr[z];
                    cd = z;
                }
            }
            sum += (cd - d) * arr[cd];

            d = cd;

            if (cd < n) {
                cd++;
            }
            if (cd < n) max = arr[cd];
        }
        System.out.println(sum);
    }
}
