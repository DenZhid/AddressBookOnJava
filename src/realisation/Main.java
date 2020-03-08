package realisation;

import java.util.Map;
import java.util.HashMap;
import addressbook.AddressBook;
import addressbook.AddressBook.Address;

public class Main {

    public static void main(String[] args) {
        //Make a new "AddressBook"
        Map<String, Address> mapOfAddresses = new HashMap<>();
        mapOfAddresses.put("Круглова", new Address("Офицерский перекрёсток", 82, 28));
        mapOfAddresses.put("Стручкова", new Address("Офицерский перекрёсток", 82, 118));
        mapOfAddresses.put("Баскова", new Address("Офицерский перекрёсток", 5, 251));
        mapOfAddresses.put("Шанский", new Address("улица Грекова", 36, 115));
        mapOfAddresses.put("Байков", new Address("улица Садовников", 47, 264));
        AddressBook firstAddressBook = new AddressBook(mapOfAddresses);

        //Print this "AddressBook"
        System.out.println("Начальная адресная книга: ");
        System.out.println(firstAddressBook);

        //Print result of method "listOfPeople" with input data of the form (street)
        System.out.println("Люди, живущие на Офицерском перекрёстке: ");
        System.out.println(firstAddressBook.listOfPeople("Офицерский перекрёсток"));

        //Print result of method "listOfPeople" with input data of the form (street, numberOfHouse)
        System.out.println("Люди, живущие на Офицерском перекрёстке, в доме 82: ");
        System.out.println(firstAddressBook.listOfPeople("Офицерский перекрёсток", 82));

        //Print result of method "add"
        firstAddressBook.add("Игнатов", new Address("Угрешский 1-й проезд", 91, 491));
        System.out.println("Адресная книга с новой записью: ");
        System.out.println(firstAddressBook);

        //Print result of method "del"
        firstAddressBook.del("Шанский");
        System.out.println("Адресная книга с удалённой записью: ");
        System.out.println(firstAddressBook);

        //Print result of method "change"
        firstAddressBook.change("Байков", new Address("улица Третьего Интернационала", 75,  63));
        System.out.println("Изменённая адресная книга: ");
        System.out.println(firstAddressBook);

        //Print result of method "getAddress"
        System.out.println("Адрес Стручковой: " + firstAddressBook.getAddress("Стручкова") );
    }
}
