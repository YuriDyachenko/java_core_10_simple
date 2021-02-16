package kurs;
/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной
фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой
фамилии должны выводиться все телефоны.
*/
import java.util.*;

public class Main {

    private static final String[] WORDS = {"Мухин", "Пономарёв", "Сусаренко", "Спивак", "Авдеев", "Куликов",
            "Сусаренко", "Авдеев", "Щербаков", "Никитин", "Бородай", "Князев", "Якушев", "Авдеев", "Сусаренко",
            "Бородай", "Романов", "Гурьев", "Авдеев", "Копылов", "Виноградов", "Сусаренко", "Родионов",
            "Хитрук", "Гурьев", "Авдеев", "Бородай", "Гурьев", "Евсеев", "Бородай", "Правый", "Беспалов"};
    private static final Random random = new Random();

    public static void main(String[] args) {

        //используем именно TreeMap, чтобы было отсортировано по алфавиту
        Map map = new TreeMap();
        //заполняем уникальными значениями слов, сразу и суммируем
        for (String word: WORDS) {
            Integer count = (Integer) map.get(word);
            map.put(word, 1 + (count == null ? 0 : count));
        }
        //просто вывод всех ключенй и значений
        for (Object key: map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }

        //телефонная книга
        PhoneBook phoneBook = new PhoneBook();
        //добавление случаных фамилий и телефонов
        for (int i = 0; i < 20; i++) {
            phoneBook.add(randomWord(), randomPhone());
        }
        //поиск телефонов по случайным фамилиям
        for (int i = 0; i < 10; i++) {
            String word = randomWord();
            System.out.println(word + ": " + phoneBook.get(word));
        }
    }

    public static String randomWord() {
        return WORDS[random.nextInt(WORDS.length)];
    }

    public static String randomPhone() {
        return "" + (4950000000L + new Random().nextInt(10000000));
    }
}
