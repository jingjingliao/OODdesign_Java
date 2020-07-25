/**
 * Represents an Address with their details--streetNumber and streetName
 * cityName stateAcronym zipCode countryName*
 * @author jingjing
 *
 */
public class Address {
    private String streetNumber;
    private String streetName;
    private String cityName;
    private String stateAcronym;
    private String zipCode;
    private String countryName;

    /**
     * Creates a new Address given the streetNumber, streetName, cityName, stateAcronym
     * zipCode, countryName
     * @param streetNumber the address's streetNumber
     * @param streetName the address's streetName
     * @param cityName the address's cityName
     * @param stateAcronym the address's stateAcronym
     * @param zipCode the address's zipCode
     * @param countryName the address's countryName
     */
    public Address(String streetNumber, String streetName, String cityName,
                   String stateAcronym, String zipCode, String countryName){
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateAcronym = stateAcronym;
        this.zipCode = zipCode;
        this.countryName = countryName;
    }

    /**
     * @return the street number
     */
    public String getStreetNumber(){
        return this.streetNumber;
    }

    /**
     * @return the street name
     */
    public String getStreetName(){
        return this.streetName;
    }

    /**
     * @return the city name
     */
    public String getCityName(){
        return this.cityName;
    }

    /**
     * @return the state acronym
     */
    public String getStateAcronym(){
        return this.stateAcronym;
    }

    /**
     * @return return the zip code
     */
    public String getZipCode(){
        return this.zipCode;
    }

    /**
     * @return the country name
     */
    public String getCountryName(){
        return this.countryName;
    }
}
