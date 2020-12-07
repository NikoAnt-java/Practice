package j120;


import java.util.Arrays;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fuzzb
 */
class StringService {
    /**
     * Метод сортирует массив строк, заданных параметром as.
     *
     * @param as исходный массив строк.
     * @param dir определяет порядок сортировки строк: если данный параметр
     * равен true, то строки сортируются в алфавитном порядке, а если данный
     * параметр равен false, то строки сортируются в обратном порядке.
     * @return возвращается отсортированный массив строк.
     * @throws StringArrayException данное исключение выбрасывается в случае,
     * если ссылка на исходный массив as равна null или в случае когда массив as
     * пуст.
     */
    public static String[] sort(String[] as, boolean dir)
            throws StringArrayException {
        if (as != null && as.length > 0) {
            //сортировка
            if (dir) {
                //сортировка по возврастанию
                Arrays.sort(as);
            } else {
                Comparator<String> cs = new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        //return o1.compareTo(o2);//прямой порядок сортирования
                        return -o1.compareTo(o2);//обратный порядок сортирования
                    }
                };
                Arrays.sort(as, cs);
            }
            return as;// возврат отсортированного массива
        } else {
            throw new StringArrayException("Массив не может быть создан");
        }
    }

    /**
     * Метод возвращает набор символов, каждый из которых хотя бы один раз
     * встречается в исходной строке str.
     *
     * @param str исходная строка.
     * @return массив уникальный символов, каждый из которых хотя бы один раз
     * встречается в исходной строке str. Если ссылка на исходный массив равна
     * null, то метод также возвращает null. Если исходная строка пуста, то
     * возвращается пустой массив.
     */
    public static char[] getCharStat(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return new char[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean charFound = false;
            for (int j = 0; j < sb.length(); j++) {
                if (c == sb.charAt(j)) {
                    charFound = true;
                    break;
                }
            }
            if (charFound) sb.append(c);
        }
        System.out.println("Sumbols: " + sb);
        char chars[] = new char[sb.length()];
        return sb.toString().toCharArray();
    }
 
}
