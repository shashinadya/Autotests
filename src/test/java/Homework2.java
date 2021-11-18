public class Homework2 {
    public static void main(String[] args) {
        //Задание 1. Создать массив из n первых чисел Фибоначчи
        System.out.println("Задание 1. Создать массив из n первых чисел Фибоначчи");
        int[] array3 = new int[10];
        array3[0] = 0;
        array3[1] = 1;
        System.out.print(array3[0] + " " + array3[1] + " ");
        for (int i = 2; i < array3.length; i++) {
            array3[i] = array3[i - 1] + array3[i - 2];
            System.out.print(array3[i] + " ");
        }
        System.out.println();

        //Задание 2. Создать массив, на четных местах в котором стоят единицы, а на нечетных местах - числа, равные остатку от деления своего номера на 5.
        System.out.println("\nЗадание 2. Создать массив, на четных местах в котором стоят единицы, а на нечетных местах - числа, равные остатку от деления своего номера на 5.");
        int[] array2 = new int[10];
        for (int i = 0; i < array2.length; i++) {
            if (i % 2 == 0) {
                array2[i] = 1;
            } else {
                array2[i] = i % 5;
            }
            System.out.print(array2[i] + " ");
        }
        System.out.println();

        //Задание 3. Найдите сумму чисел массива, которые стоят на четных местах.
        System.out.println("\nЗадание 3. Найдите сумму чисел массива, которые стоят на четных местах.");
        int[] array1 = new int[]{1, 5, 3, 4, 7, 9, 7, 8, 9, 11};
        int sum = 0;
        for (int i = 0; i < array1.length; i++) {
            if (i % 2 == 0)
                sum = sum + array1[i];
        }
        System.out.println(sum);

        //Задание 4. Даны две строки. Вывести большую по длине строку столько раз, на сколько символов отличаются строки.
        System.out.println("\nЗадание 4. Даны две строки. Вывести большую по длине строку столько раз, на сколько символов отличаются строки.");
        String str1 = "Первая строка";
        String str2 = "Вторая строка длиннее первой строки";
        int countStr1 = str1.length();
        int countStr2 = str2.length();

        if (countStr1 > countStr2) {
            int dif1 = countStr1 - countStr2;
            System.out.println(str1.repeat(dif1));
        } else if (countStr1 < countStr2) {
            int dif2 = countStr2 - countStr1;
            System.out.print(str2.repeat(dif2));
        } else {
            System.out.println("Количество символов в обеих строках совпадает");
        }

        //Задание 5. Дана строка. Вывести ее три раза через запятую и показать количество символов в ней.
        System.out.println("\nЗадание 5. Дана строка. Вывести ее три раза через запятую и показать количество символов в ней.");
        String str = "Дана строка";
        System.out.println(str + ", " + str + ", " + str);
        System.out.println("Количество символов в строке равно " + str.length());

        //Задание 6. Дано предложение. Посчитать количество слов в данном предложении
        System.out.println("\nЗадание 6. Дано предложение. Посчитать количество слов в данном предложении");
        String proposal = "Посчитать количество слов в данном предложении";
        int count = 0;
        count++;
        for (int i = 0; i < proposal.length(); i++) {
            if (proposal.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println(proposal);
        System.out.println("Количество слов в строке равно " + count);
    }
}
