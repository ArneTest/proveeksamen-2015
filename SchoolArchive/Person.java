
/**
 * The Person class is the super-class for any person to be handled
 * by the application.
 *
 * @author Arne Styve
 * @version 2015-05-02
 */
public class Person {

    private String name;    // The name of the person
    private String address; // The Address of the person
    private int age;        // The age of the person

    /**
     * Creates an object of Person
     * 
     * @param name the name of the person
     * @param address the address of the person
     * @param age the age of the person
     */
    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    /**
     * Creates an object of Person using dummy values/empty
     * values for the fields name, address and age.
     */
    public Person() {
        this.name = "";
        this.address = "";
        this.age = 0;
    }
    
    /**
     * Returns a string holding the details of the person.
     * 
     * @return a string holding all details about the person
     */
    public String getDetailsString()
    {
        String result = "Name: " + this.getName()
                + " Address: " + this.getAddress()
                + " Age: " + this.getAge();
        return result;
    }

    // Accessor- and mutator methods
    
    /**
     * Sets the name of the person.
     * 
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the address of the person.
     * 
     * @param address the address to be set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the age of the person.
     * 
     * @param age the age to be set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the name of the person.
     * 
     * @return the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address of the person.
     * @return the address of the person
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the age of the person
     * 
     * @return the age of the person
     */
    public int getAge() {
        return age;
    }    
    
}
