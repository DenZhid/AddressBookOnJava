package testsForAdressBook;

import addressbook.AddressBook;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import addressbook.AddressBook.Address;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddressBookTest {

    @Test
   public void add() {
        //Make a new AddressBook
        AddressBook book = new AddressBook(new HashMap<>());
        book.add(new Pair<>("Круглова", new Address("Офицерский пер", 82, 28)));

        //Making Map and AddressBook for testing
        Map<String, Address> mapForTest = new HashMap<>();
        mapForTest.put("Круглова", new Address("Офицерский пер", 82, 28));
        AddressBook bookForTest = new AddressBook(mapForTest);

        Assert.assertEquals(book, bookForTest); //test 1

        //Adding another member of address book
        book.add(new Pair<>("Стручкова", new Address("Офицерский пер", 82, 118)));
        //Adding this element to a testing Map, which forming the AddressBook for testing
        mapForTest.put("Стручкова", new Address("Офицерский пер", 82, 118));

        Assert.assertEquals(book, bookForTest); //test 2

        //Firstly, adding a new member to the address book
        book.add(new Pair<>("", new Address("", 0, 0)));
        /*Secondly, trying to add another member with same name.
        Method should not work, since such an element already exists, and for changing the address we have a function "change"*/
        book.add(new Pair<>("", new Address("", 2, 1)));
        //Adding desired element to the Map
        mapForTest.put("", new Address("", 0, 0));

        Assert.assertEquals(book, bookForTest); //test 3
    }

    @Test
    public void del() {
    }

    @Test
    public void change() {
    }

    @Test
    public void getAddress() {
    }

    @Test
    public void listOfPeople() {
        Map<String, Address> mapOfAddresses = new HashMap<>();
        mapOfAddresses.put("Круглова", new Address("Офицерский пер", 82, 28));
        mapOfAddresses.put("Стручкова", new Address("Офицерский пер", 82, 118));
        mapOfAddresses.put("Баскова", new Address("Офицерский пер", 5, 251));
        mapOfAddresses.put("Шанский", new Address("Грекова туп", 36, 115));
        mapOfAddresses.put("Байков", new Address("Садовники", 47, 264));
        AddressBook book = new AddressBook(mapOfAddresses);
        Assert.assertEquals(
                book.listOfPeople("Офицерский пер"),
                Arrays.asList("Стручкова", "Баскова", "Круглова")
        );
        Assert.assertEquals(
                book.listOfPeople("Офицерский пер", 82),
                Arrays.asList("Стручкова", "Круглова")
        );
    }
}
