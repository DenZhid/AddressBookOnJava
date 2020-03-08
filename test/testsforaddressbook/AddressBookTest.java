package testsforaddressbook;

import addressbook.AddressBook;
import org.junit.Assert;
import org.junit.Test;
import addressbook.AddressBook.Address;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddressBookTest {

    @Test
    public void getStreet() {
        Address addressForTest = new Address("Офицерский пер", 82, 28);
        Assert.assertEquals("Офицерский пер", addressForTest.getStreet());
    }

    @Test
    public void getNumberOfHouse() {
        Address addressForTest = new Address("Офицерский пер", 82, 28);
        Assert.assertEquals(82, addressForTest.getNumberOfHouse());
    }

    @Test
    public void getNumberOfFlat() {
        Address addressForTest = new Address("Офицерский пер", 82, 28);
        Assert.assertEquals(28, addressForTest.getNumberOfFlat());
    }

    @Test
   public void add() {
        //Make a new "AddressBook"
        AddressBook book = new AddressBook(new HashMap<>());
        book.add("Круглова", new Address("Офицерский пер", 82, 28));

        //Making "AddressBook" for testing
        Map<String, Address> mapForTest = new HashMap<>();
        mapForTest.put("Круглова", new Address("Офицерский пер", 82, 28));
        AddressBook bookForTest = new AddressBook(mapForTest);

        Assert.assertEquals(book, bookForTest); //test 1

        //Adding another member of address book
        book.add("Стручкова", new Address("Офицерский пер", 82, 118));

        //Adding this element to a testing Map, which forming the "AddressBook" for testing
        mapForTest.put("Стручкова", new Address("Офицерский пер", 82, 118));

        Assert.assertEquals(book, bookForTest); //test 2

        //Firstly, adding a new member to the address book
        book.add("", new Address("", 0, 0));

        /*Secondly, trying to add another member with same name.
        Method should not work, since such an element already exists, and for changing the address we have a function "change"*/
        book.add("", new Address("", 2, 1));

        //Adding desired element to the Map
        mapForTest.put("", new Address("", 0, 0));

        Assert.assertEquals(book, bookForTest); //test 3

        Assert.assertTrue(
                book.add(
                        "Баскова",
                        new Address("Офицерский перекрёсток", 5, 251)
                )
        ); //test 4

        Assert.assertFalse(
                book.add(
                "Круглова",
                new Address("Офицерский пер", 82, 28)
                )
        ); //test 5
    }

    @Test
    public void del() {
        //Make a new "AddressBook"
        AddressBook book = new AddressBook(new HashMap<>());
        book.add("Круглова", new Address("Офицерский перекрёсток", 82, 28));
        book.add("Стручкова", new Address("Офицерский перекрёсток", 82, 118));
        book.add("Баскова", new Address("Офицерский перекрёсток", 5, 251));

        //Make an "AddressBook" for testing
        Map<String, Address> mapForTest = new HashMap<>();
        mapForTest.put("Круглова", new Address("Офицерский перекрёсток", 82, 28));
        mapForTest.put("Стручкова", new Address("Офицерский перекрёсток", 82, 118));
        AddressBook bookForTest = new AddressBook(mapForTest);

        book.del("Баскова");
        Assert.assertEquals(book, bookForTest); //test 1

        book.del("Стручкова");
        mapForTest.remove("Стручкова");
        Assert.assertEquals(book, bookForTest); //test 2

        book.del("Круглова");
        mapForTest.remove("Круглова");
        Assert.assertEquals(book, bookForTest); //test 3

        book.del("Игнатов");
        Assert.assertEquals(book, bookForTest); //test 4

        book.add("Шанский", new Address("улица Грекова", 36, 115));

        Assert.assertTrue(book.del("Шанский")); //test 5

        Assert.assertFalse(book.del("Лабудыев")); //test 6
    }

    @Test
    public void change() {
        //Make a new "AddressBook"
        AddressBook book = new AddressBook(new HashMap<>());
        book.add("Круглова", new Address("Офицерский перекрёсток", 82, 28));

        //Make an "AddressBook" for testing
        Map<String, Address> mapForTest = new HashMap<>();
        mapForTest.put("Круглова", new Address("улица Грекова", 36, 115));
        AddressBook bookForTest = new AddressBook(mapForTest);

        //Change entry in "AddressBook"
        book.change("Круглова", new Address("улица Грекова", 36, 115));
        Assert.assertEquals(book, bookForTest); //test 1

        //Trying to change entry in "AddressBook", which doesn't exist
        book.change("Стручкова", new Address("Офицерский перекрёсток", 82, 118));
        Assert.assertEquals(book, bookForTest); //test 2

        Assert.assertTrue(
                book.change(
                "Круглова",
                        new Address("улица Садовников", 47, 264)
                )
        );

        Assert.assertFalse(
                book.change(
                        "Стручкова",
                        new Address("Офицерский перекрёсток", 82, 118)
                )
        );
    }

    @Test
    public void getAddress() {
        //Make a new "AddressBook"
        AddressBook book = new AddressBook(new HashMap<>());
        book.add("Круглова", new Address("Офицерский перекрёсток", 82, 28));

        Assert.assertEquals(
                book.getAddress("Круглова"),
                new Address("Офицерский перекрёсток", 82, 28)
        ); //test 1

        //Trying to find address which doesn't exist
        Assert.assertNotEquals(
                book.getAddress("Шанский"),
                new Address("улица Грекова", 36, 115)
        ); //test 2
    }

    @Test
    public void listOfPeople() {
        //Make a new "AddressBook"
        Map<String, Address> mapOfAddresses = new HashMap<>();
        mapOfAddresses.put("Круглова", new Address("Офицерский пер", 82, 28));
        mapOfAddresses.put("Стручкова", new Address("Офицерский пер", 82, 118));
        mapOfAddresses.put("Баскова", new Address("Офицерский пер", 5, 251));
        AddressBook book = new AddressBook(mapOfAddresses);

        //Method with input data of the form (street)
        Assert.assertEquals(
                book.listOfPeople("Офицерский пер"),
                Arrays.asList("Стручкова", "Баскова", "Круглова")
        ); //test 1

        //Method with input data of the form (street, numberOfHouse)
        Assert.assertEquals(
                book.listOfPeople("Офицерский пер", 82),
                Arrays.asList("Стручкова", "Круглова")
        ); //test 2
    }
}