package kurs;
/*
класс ТЕЛЕФОННАЯ КНИГА***
все отсортировано, как фамилии, так и телефоны "внутри фамилии"
не требуются никакие дополнительные классы типа "запись телефонной книги"
*/
import java.util.*;

public class PhoneBook {
    private final Map map = new TreeMap();

    public void add(String name, String phone) {
        Set phones = (map.containsKey(name)) ? (Set) map.get(name) : new TreeSet();
        phones.add(phone);
        map.put(name, phones);
    }

    public String get(String name) {
        Set phones = (Set) map.get(name);
        return (phones == null || phones.size() == 0 ? "телефон не найден" :
                phones.toString().replace("[", "").replace("]", ""));
    }
}
