package java2.lesson23;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    final private Map<String, Set<String>> book = new HashMap<>();

    public Set<String> get(String name) {
        return book.get(name);
    }

    public void add(String name, String phone) {
        Set<String> value = book.get(name);
        if (value == null) {
            value =  new HashSet<String>();
            book.put(name, value);
        }
        value.add(phone);
    }

    @Override
    public String toString() {
        return "Phonebook{" + book + '}';
    }
}
