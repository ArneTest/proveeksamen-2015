
/**
 * The Student class represents a student. A student has a unique student
 * number which is provided to the student upon the start of his study.
 *
 * @author Arne Styve
 * @version 2015-05-02
 */
public class Student extends Person {

    private int studentNumber; // The student number

    /**
     * Creates an object of Student with the information provided by
     * the parameters.
     * 
     * @param name the name of the student
     * @param address address of the student
     * @param age age of the student
     * @param studentNumber the student number
     */
    public Student(String name, String address,
            int age, int studentNumber) {
        super(name, address, age);
        this.studentNumber = studentNumber;
    }

    /**
     * Returns the student number.
     * 
     * @return the student number as a positive integer
     */
    public int getStudentNumber() {
        return this.studentNumber;
    }
    
    /**
     * Sets the student number. The student number must be a positive integer > 0,
     * otherwise an IllegalArgumentException will be thrown.
     * 
     * @param studentNumber the student number, as a positive integer > 0
     * @throws IllegalArgumentException if student number is not a positive integer
     */
    public void setStudentNumber(int studentNumber) throws IllegalArgumentException
    {
        if ( studentNumber <= 0)
        {
            throw new IllegalArgumentException("Student number must be a positive integer > 0. Was " + studentNumber);
        } 
        else
        {
            this.studentNumber = studentNumber;
        }
            
    }
    
    /**
     * Returns a string holding the details of the student.
     * 
     * @return a string holding all details about the student
     */
    @Override
    public String getDetailsString()
    {
        String result = super.getDetailsString()
                + " Stud No: " + this.getStudentNumber();
        return result;
    }
    

}
