package PhoneBook;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class PhoneBook {
    private Map<String, List<String>> mapNumbers;

    public void add(String lastName, String phoneNumber) {
        if (lastName == null || phoneNumber == null || lastName.isEmpty() || phoneNumber.isEmpty()) {
            System.out.println("Невозможно добавить запись: не указана фамилия или номер");
            return;
        }
        if (mapNumbers == null) {
            mapNumbers = new HashMap<>();
        }
        lastName = lastName.toUpperCase();
        if (mapNumbers.containsKey(lastName)) {
            List<String> numbers = mapNumbers.get(lastName);
            if (numbers.contains(phoneNumber)) {
                System.out.println("Такая запись уже есть");
                return;
            }
            numbers.add(phoneNumber);
            mapNumbers.put(lastName, numbers);
        } else {
            List<String> newNameNumbers = new ArrayList<>();
            newNameNumbers.add(phoneNumber);
            mapNumbers.put(lastName, newNameNumbers);
        }
        System.out.println(lastName + "(" + phoneNumber + ") добавлен");
    }

    public void get(String lastName) {
        if (mapNumbers == null) {
            System.out.println("Справочник пуст");
            return;
        }
        if (lastName == null || lastName.isEmpty()) {
            System.out.println("Невозможно выполнить поиск: не указана фамилия");
            return;
        }
        lastName = lastName.toUpperCase();
        if (!mapNumbers.containsKey(lastName)) {
            System.out.println(lastName + " не найден");
            return;
        }
        System.out.println("Номера " + lastName + ": ");
        mapNumbers
                .get(lastName)
                .forEach(System.out::println);

    }

    public void printAll() {
        if (mapNumbers == null || mapNumbers.isEmpty()) {
            return;
        }
        mapNumbers
                .entrySet()
                .forEach(System.out::println);
    }
}
