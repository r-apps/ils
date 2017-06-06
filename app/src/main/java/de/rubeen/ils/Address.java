package de.rubeen.ils;

/**
 * Created by rubeen on 05.06.17.
 *
 * Address as struct, with toString()-method
 */

public class Address {
    private final String street;
    private final String zip;
    private final String city;

    /**
     * creates an normal address object
     *
     * @param street as part of the address
     * @param zip    as part of the address
     * @param city   as part of the address
     */
    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    //Getter

    /**
     *
     * @return readable street with house number
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @return readable zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     *
     * @return readable city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return readable address (f.e. "Peter-street 35, 11111 Berlin")
     */
    @Override
    public String toString() {
        return getStreet().concat(", ").concat(getZip()).concat(" ").concat(getCity());
    }
}
