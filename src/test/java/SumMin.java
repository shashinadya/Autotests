import java.util.Arrays;
import java.util.Scanner;

public class SumMin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int number1 = in.nextInt();
        System.out.print("Input a number: ");
        int number2 = in.nextInt();
        in.close();

        int min = Math.min(number1, number2);
        System.out.println("Минимальное из введённых чисел равно " + min);
        int sum = 0;
        for (int i = 1; i <= min; i++) {
            sum += i;
        }
            System.out.println("Сумма всех чисел до минимального числа включительно равна " + sum);
    }
}
