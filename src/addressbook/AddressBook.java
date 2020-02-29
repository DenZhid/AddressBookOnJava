package addressbook;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class AddressBook {

    public static class Address {

        private final String street;
        private final int numberOfHouse;
        private final int numberOfFlat;

        public Address(String street, int numberOfHouse, int numberOfFlat) {
            this.street = street;
            this.numberOfHouse = numberOfHouse;
            this.numberOfFlat = numberOfFlat;
        } //Constructor of class "Address"

        @Override
        public String toString() {
            return  street + ", " + numberOfHouse + ", " + numberOfFlat;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Address other = (Address) obj;
            if (!street.equals(other.street))
                return false;
            if (numberOfHouse != other.numberOfHouse)
                return false;
            return numberOfFlat == other.numberOfFlat;
        }

        @Override
        public int hashCode() {
            return street.hashCode();
        }
    } //Class "Address"

    private Map<String, Address> mapOfAddresses;

    public AddressBook(Map<String, Address> mapOfAddresses) {
        this.mapOfAddresses = mapOfAddresses;
    } //Constructor of Class "AddressBook"

    public void add(Pair<String, Address> pairForAdd) {
        if (!mapOfAddresses.containsKey(pairForAdd.getKey()))mapOfAddresses.put(pairForAdd.getKey(), pairForAdd.getValue());
    } //Method adding a couple of people to the address to address book

    public void del(String person) {
        mapOfAddresses.remove(person);
    } //Method deleting an address book entry

    public void change(String person, Address newAddress) {
        if (mapOfAddresses.containsKey(person)) mapOfAddresses.put(person, newAddress);
    } //Method changing an address book entry

    public Address getAddress(String person) {
        return mapOfAddresses.get(person);
    } //Method by which you can get the address of a person

    public List<String> listOfPeople(String street) {
        List<String> listOfPeople = new ArrayList<>();
        for (Map.Entry<String, Address> elements: mapOfAddresses.entrySet())
            if (elements.getValue().street.equals(street)) listOfPeople.add(elements.getKey());
        return listOfPeople;
    } //Method by which you can get a list of people living on this street

    public List<String> listOfPeople(String street, int numberOfHouse ) {
        List<String> listOfPeople = new ArrayList<>();
        for (Map.Entry<String, Address> elements: mapOfAddresses.entrySet())
            if (elements.getValue().street.equals(street) && elements.getValue().numberOfHouse == numberOfHouse)
                listOfPeople.add(elements.getKey());
            return listOfPeople;
    } //Method by which you can get a list of people living on this street and in this house

   @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("{");
       for (Map.Entry<String, Address> element: mapOfAddresses.entrySet()) {
           sb.append(element.getKey());
           sb.append(": ");
           sb.append(element.getValue().street);
           sb.append(", ");
           sb.append(element.getValue().numberOfHouse);
           sb.append(", ");
           sb.append(element.getValue().numberOfFlat);
           sb.append("; ");
       }
       sb.setLength(sb.length() - 2);
       sb.append("}");
       return sb.toString();
   }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AddressBook other = (AddressBook) obj;
        return mapOfAddresses.equals(other.mapOfAddresses);
    }

    @Override
    public int hashCode() {
        return mapOfAddresses.hashCode();
    }
}