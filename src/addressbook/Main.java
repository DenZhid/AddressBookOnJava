package addressbook;

import java.util.Map;
import java.util.HashMap;
import javafx.util.Pair;

public class Main {

    public static void main(String[] args) {
        Map<String, AddressBook.Address> mapOfAddresses = new HashMap<>();
        mapOfAddresses.put("Круглова", new AddressBook.Address("Офицерский пер", 82, 28));
        mapOfAddresses.put("Стручкова", new AddressBook.Address("Офицерский пер", 82, 118));
        mapOfAddresses.put("Баскова", new AddressBook.Address("Офицерский пер", 5, 251));
        mapOfAddresses.put("Шанский", new AddressBook.Address("Грекова туп", 36, 115));
        mapOfAddresses.put("Байков", new AddressBook.Address("Садовники", 47, 264));
        AddressBook firstAddressBook = new AddressBook(mapOfAddresses);
        System.out.println("Начальная адресная книга: ");
        System.out.println(firstAddressBook);
        System.out.println("Люди, живущие на Офицерском перекрёстке: ");
        System.out.println(firstAddressBook.listOfPeople("Офицерский пер"));
        System.out.println("Люди, живущие на Офицерском перекрёстке, в доме 82: ");
        System.out.println(firstAddressBook.listOfPeople("Офицерский пер", 82));
        firstAddressBook.add(new Pair<>("Игнатов", new AddressBook.Address(" Угрешский 1-й проезд", 91, 491)));
        System.out.println("Адресная книга с новой записью: ");
        System.out.println(firstAddressBook);
        firstAddressBook.del("Шанский");
        System.out.println("Адресная книга с удалённой записью: ");
        System.out.println(firstAddressBook);
        firstAddressBook.change("Байков", new AddressBook.Address("Третьего Интернационала", 75,  63));
        System.out.println("Изменённая адресная книга: ");
        System.out.println(firstAddressBook);
        System.out.println("Адрес Стручковой: " + firstAddressBook.getAddress("Стручкова") );
    }
}
