package ru.gb.lesson4.homework;

import java.util.Scanner;

public class SqTriangle {
    public static void main(String[] args) {

        // Объявляем переменные для значений сторон
        int x;
        int y;
        int z;

        // Сканер для считывания вводимых значений
        Scanner sc = new Scanner(System.in);

        System.out.println("Для нахождения площади треугольника " +
                           "введите по очереди значения всех сторон");

        // Цикл с постусловием для проверки вводимых значений
        do {
            System.out.println("Введите значение стороны A :");
            x = sc.nextInt();
            System.out.println("Введите значение стороны B :");
            y = sc.nextInt();
            System.out.println("Введите значение стороны C :");
            z = sc.nextInt();
            // Цикл do будет выполняться пока while = true
        } while (isValid(x,y,z));


        sqTriangle(x,y,z);
    }
    // Метод проверки вводимых значений на соответствие условиям
    public static boolean isValid(int x, int y, int z) {
        // Проверка на то, что вводимые значения каждой из сторон > 0
        if (x <= 0 || y <= 0 || z <= 0) {
            System.out.println("\nВведите значение больше 0!\n");
            return true;
        }
        // Проверка на то, что сумма двух сторон больше третьей
        if (x + y <= z || y + z <= x || z + x <= y){
            System.out.println("\n" +
                               "Одна сторона больше или равна сумме двух других сторон. \n" +
                               "Такой треугольник не может существовать. \n" +
                               "Введите корректные значения сторон!\n");
            return true;
        }
        return false;
    }

    public static void sqTriangle(int a, int b, int c) {
        double s;
        double p;

        p = ((a + b + c)/2f);
        //System.out.println(p);

        s = Math.sqrt(p * (p - a) * ( p - b) * (p - c));
        String result = String.format("%.4f",s);
        //System.out.println(s);

        System.out.println("Площадь треугольника ABC равна : " + result);
    }
}
