package problem1;

/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number
 * (VIN), and corresponding license plate
 */
public class Vehicle {
    private int VIN;
    private String licensePlate;
    private Owner owner;

    /**
     * Constructor that creates a new vehicle object with the specified VIN
     * license plate
     * @param VIN VIN of the new Vehicle object
     * @param licensePlate license plate of the new Vehicle
     * @param owner owner of the vehicle
     */
    public Vehicle(int VIN, String licensePlate, Owner owner){
        this.VIN = VIN;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    /**
     * Returns the VIN of the Vehicle
     * @return Returns the VIN of the Vehicle
     */
    public int getVIN(){
        return this.VIN;
    }

    /**
     * Returns the licensePlate of the Vehicle
     * @return the licensePlate of the Vehicle
     */
    public String getLicensePlate() {
        return this.licensePlate;
    }

    /** Returns the owner of the Vehicle
     * @return the owner of the vehicle
     */
    public Owner getOwner(){
        return this.owner;
    }

    /**
     * @param VIN Sets the VIN of the Vehicle
     */
    public void setVIN(int VIN){
        this.VIN = VIN;
    }

    /**
     * @param licensePlate Sets the licensePlate of the Vehicle
     */
    public void  setLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }

    /**
     * @param owner Sets the owner of the vehicle
     */
    public void setOwner(Owner owner){
        this.owner = owner;
    }
}
