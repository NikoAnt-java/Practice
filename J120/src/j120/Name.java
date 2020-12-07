package j120;


import java.util.HashMap;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fuzzb
 */
public class Name {

    public static User users[] = new User[5];
    static int numOfUsers = 0;

    public static void main(String[] args) {
        String as[] = {"Мария", "Иван", "Кощей", "Яга", "Горяныч", "Илья"};//строковый массив имён
        for (String s : as) {
            System.out.print(s + " ");
        }
        System.out.println("");
        String sas[] = null;
        try {
            sas = StringService.sort(as, true);
        } catch (StringArrayException ex) {
            System.out.println("Получено исключение: " + ex.getMessage());
        }
        for (String s : sas) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        String chars = "12vhj3b2h33aaaa43vvvjj4h";//ввод только цифр и латинских букв
        char charset[] = StringService.getCharStat(chars);
        System.out.println(chars);
        for (char c : charset) {
            System.out.println(c);
        }
        System.out.println();
        // подсчет количества символов в строке
        int[] arr = new int[255];
        for (int i = 0; i < chars.length(); i++) {
            arr[chars.charAt(i)]++;
        }
        // вывод на экран
        for (int i = 0; i < 255; i++) {
            if (arr[i] > 0) {
                System.out.println((char) i + " найдено " + arr[i] + " раз");
            }
        }
    }
}
