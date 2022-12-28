package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println("Задание 1 - заменить элементы массива");
    changeArrayElements();
    System.out.println("Задание 2 - заполнить массив с помощью цикла");
    initializeArray();
    System.out.println("Задание 3 - пройтись по массиву и числа меньшие 6 умножить на 2");
    handleArray();
    System.out.println("Задание 4 - работа с двумерными массивами");
    initializeTable();
    System.out.println("Задание 5 - найти минимальный и максимальный элементы");
    findMinMax();
    System.out.println("Задание 6 - проверить массив на совпадение сумм левой и правой части");
    int[] arrayTaskSixOne = {2, 2, 2, 1, 2, 2, 10, 1};
    checkBalance(arrayTaskSixOne);
    int[] arrayTaskSixTwo = {1, 1, 1, 2, 1};
    checkBalance(arrayTaskSixTwo);
    int[] arrayTaskSixThree = {1, 8, 1, 2, 1};
    checkBalance(arrayTaskSixThree);
    System.out.println("Задание 7 - сместить элементы массива на n");
    int[] arrayTaskSeven = {1, 2, 3, 4, 5, 6, 7, 8};
    displaseArrayElements(arrayTaskSeven, 3);
    displaseArrayElements(arrayTaskSeven, -3);
  }

  private static void changeArrayElements() {
    int[] array = {1, 1, 0, 1, 1, 0, 0};
    System.out.printf("%s\n", Arrays.toString(array));
    for (int i = 0; i < array.length; i++) {
      switch (array[i]) {
        case 0 -> array[i] = 1;
        default -> array[i] = 0;
      }
    }
    System.out.printf("%s\n", Arrays.toString(array));
  }

  private static void initializeArray() {
    int[] array = new int[8];
    for (int i = 0; i < array.length; i++) {
      array[i] = i * 3;
    }
    System.out.printf("%s\n", Arrays.toString(array));
  }

  private static void handleArray() {
    int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    System.out.printf("%s\n", Arrays.toString(array));
    for (int i = 0; i < array.length; i++) {
      if (array[i] < 6) {
        array[i] = array[i] * 2;
      }
    }
    System.out.printf("%s\n", Arrays.toString(array));
  }

  private static void initializeTable() {
    int[][] table = new int[5][5];
    for (int a = 0; a < table.length; a++) {
      System.out.printf("%s\n", Arrays.toString(table[a]));
      for (int b = 0; b < table[a].length; b++) {
        if (a == b) {
          table[a][b] = 1;
        }
      }
    }
    System.out.println("----------");
    for (int[] row : table) {
      System.out.printf("%s\n", Arrays.toString(row));
    }
  }

  private static void findMinMax() {
    int[] array = {13, 745, 20, 1236, 672, 572};
    System.out.printf("%s\n", Arrays.toString(array));
    int min = array[0];
    int max = array[0];
    for (int i : array) {
      if (i < min) {
        min = i;
      }
      if (i > max) {
        max = i;
      }
    }
    System.out.printf("min = %s\n", min);
    System.out.printf("max = %s\n", max);
  }

  private static boolean checkBalance(int[] array) {
    System.out.printf("%s\n", Arrays.toString(array));
    for (int i = 0; i < array.length; i++) {
      int leftSum = 0;
      int rightSum = 0;
      for (int index = 0; index < array.length; index++) {
        if (index <= i) {
          leftSum += array[index];
        } else {
          rightSum += array[index];
        }
      }
      if (leftSum == rightSum) {
        System.out.printf("левая сумма - %d\n", leftSum);
        System.out.printf("правая сумма - %d\n", rightSum);
        System.out.println("В массиве есть место в котором сумма левой и правой части массива равны");
        return true;
      }
    }
    System.out.println("В массиве нет мест, в которой сумма левой и правой части массива равны");
    return false;
  }

  private static void displaseArrayElements(int[] array, int n) {
    System.out.printf("%s - сместить на %d\n", Arrays.toString(array), n);
    if (n == 0) {
      System.out.println("n не может быть равен нулю");
    } else if (n > 0) {
      for (int iteration = 0; iteration < n; iteration++) {
        for (int index = 1; index < array.length; index++) {
          int firstElement = array[0];
          int secondElement = array[index];
          array[0] = secondElement;
          array[index] = firstElement;
        }
      }
    } else {
      for (int iteration = 0; iteration > n; iteration--) {
        for (int index = array.length - 1; index >= 0; index--) {
          int firstElement = array[array.length - 2];
          int secondElement = array[index];
          array[array.length - 2] = secondElement;
          array[index] = firstElement;
        }
      }
    }
    System.out.println(Arrays.toString(array));
  }
}