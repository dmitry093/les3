package PhoneBook;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.printAll();

        phoneBook.get("Петров");

        phoneBook.add("Иванов", "89991234567");
        phoneBook.add("иванов", "89997654321");
        phoneBook.add("Сидоров", "891234567890");
        phoneBook.add("Сидоров", "891234567890");
        phoneBook.add("", "89191234567");
        phoneBook.add("Петров", null);
        phoneBook.add("Петров", "89501234567");

        phoneBook.get(null);
        phoneBook.get("Иванов");
        phoneBook.get("Сидоров");
        phoneBook.get("Петров");

        phoneBook.printAll();
    }
}
