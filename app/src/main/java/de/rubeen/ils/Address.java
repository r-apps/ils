package de.rubeen.ils;

/**
 * Created by rubeen on 05.06.17.
 */

public class Address {
    private String street;
    private String zip;
    private String city;

    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    //Getter
    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(city);
        builder.append(", ");
        builder.append(zip);
        builder.append(" ");
        builder.append(city);
        return builder.toString();
    }
}
