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

        int sum = number1 + number2;
        System.out.println("Сумма введённых чисел равна " + sum);
    }
}
