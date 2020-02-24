/*
     ThemeName: Адрессная книга на Java
     Author: Denis Zhidkov
     Description: Создать класс, который хранит список адресов различных людей. Адрес состоит из улицы, номера дома, и
                  номера квартиры. Человек задаётся фамилией, для каждого человека хранится лишь один адрес.
                  Методы: добавление пары человек-адрес, удаление человека, изменение адреса человека, получение адреса
                  человека, получение списка людей, живущих на заданной улице или в заданном доме.
     Version: 0.5
*/
package addressbook;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class AddressBook {

    public static class Address {

        public String street;
        public int numberOfHouse;
        public int numberOfFlat;

        public Address(String street, int numberOfHouse, int numberOfFlat) {
            this.street = street;
            this.numberOfHouse = numberOfHouse;
            this.numberOfFlat = numberOfFlat;
        }

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
    }

    public Map<String, Address> mapOfAddresses;

    public AddressBook(Map<String, Address> mapOfAddresses) {
        this.mapOfAddresses = mapOfAddresses;
    }

    public void add(Pair<String, Address> pairForAdd) {
        if (!mapOfAddresses.containsKey(pairForAdd.getKey()))mapOfAddresses.put(pairForAdd.getKey(), pairForAdd.getValue());
    }

    public void del(String person) {
        mapOfAddresses.remove(person);
    }

    public void change(String person, Address newAddress) {
        if (mapOfAddresses.containsKey(person)) mapOfAddresses.put(person, newAddress);
    }

    public Address getAddress(String person) {
        return mapOfAddresses.get(person);
    }

    public List<String> listOfPeople(String street) {
        List<String> listOfPeople = new ArrayList<>();
        for (Map.Entry<String, Address> elements: mapOfAddresses.entrySet())
            if (elements.getValue().street.equals(street)) listOfPeople.add(elements.getKey());
        return listOfPeople;
    }

    public List<String> listOfPeople(String street, int numberOfHouse ) {
        List<String> listOfPeople = new ArrayList<>();
        for (Map.Entry<String, Address> elements: mapOfAddresses.entrySet())
            if (elements.getValue().street.equals(street) && elements.getValue().numberOfHouse == numberOfHouse)
                listOfPeople.add(elements.getKey());
            return listOfPeople;
    }

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