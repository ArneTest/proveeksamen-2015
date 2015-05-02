
/**
 * Represents a Teacher. A teacher has a position at the university.
 * Position is typically Assistant Professor, Associate Professor etc.
 *
 * @author Arne Styve
 * @version 2015-05-02
 */
public class Teacher extends Person {

    private String position;  // The position at the university/school

    /**
     * Creates an object of Teacher.
     * 
     * @param name the name of the teacher
     * @param address the address of the teacher
     * @param age the age of the teacher
     * @param position the position that the teacher holds at the university/school
     */
    public Teacher(String name, String address, int age, String position) {
        super(name, address, age);
        this.position = position;
    }

    /**
     * Returns the position that the teacher holds at the school.
     * 
     * @return the position the teacher holds at the school
     */
    public String getPosition() {
        return this.position;
    }
    
    /**
     * Sets the position that the teacher holds.
     * 
     * @param position the position the teacher holds
     */
    public void setPosition( String position )
    {
        this.position = position;
    }

}
