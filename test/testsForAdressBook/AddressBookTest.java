package testsForAdressBook;

import addressbook.AddressBook;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class AddressBookTest {
    @Test
   public void add() {
        AddressBook book = new AddressBook(new HashMap<>());
        Assert.assertEquals(
                book.add(new Pair<>("Круглова", new AddressBook.Address("Офицерский пер", 82, 28))),
                new AddressBook(new Map(){{"Круглова", new AddressBook.Address("Офицерский пер", 82, 28)};
        );
    }

}
