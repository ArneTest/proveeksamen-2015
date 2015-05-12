
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the application and is responsible for providing the
 * necessary functionality for the user.
 *
 * @author asty
 */
public class SchoolArchiveApplication {

    private PersonArchive personArchive;

    /**
     * Creates an instance of the SchoolArchiveApplication class.
     */
    public SchoolArchiveApplication() {
        this.personArchive = new PersonArchive();
        this.fillArchiveWithTestData();
    }

    /**
     * The main method of the SchoolArchiveApplication class. Calling this
     * method starts the application, by showing the menu and accepting input
     * from the user until the user decides to quit.
     */
    public void run() {
        boolean quit = false;

        while (!quit) {
            try {
                int menuSelection = this.showMenu();
                switch (menuSelection) {
                    case 1:
                        this.doListAllPersons();
                        break;

                    case 2:
                        this.doListTeachers();
                        break;

                    case 3:
                        this.doAddStudent();
                        break;

                    case 4:
                        System.out.println("\nThank you for using School Archive v1.0. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and 4..\n");
            }
        }
    }

    /**
     * Lists all content of the collection provided as parameter.
     *
     * @param collection the collection containing the elements to list
     */
    public void listAllContent(Collection<Person> collection) {
        for (Person tmpPers : collection) {
            System.out.println(tmpPers.getDetailsString());
        }
    }

    /**
     * Fills the person archive with students and teachers. To be used mainly
     * for test purposes.
     */
    private void fillArchiveWithTestData() {
        Student s1 = new Student("Frank Smith", "Coppergate 34, York", 34, 123);
        this.personArchive.addPerson(s1);
        s1 = new Student("John McGregor", "Mainstreet 25, Newcastle", 25, 210);
        this.personArchive.addPerson(s1);
        s1 = new Student("Julie Jamson", "Low street 12, Leeds", 21, 324);
        this.personArchive.addPerson(s1);
        s1 = new Student("Eva Bowry", "Oxford Street 321, London", 32, 713);
        this.personArchive.addPerson(s1);

        Teacher t1 = new Teacher("Oliver Jones", "Upper street 21", 54, "Assistant Professor");
        this.personArchive.addPerson(t1);
        t1 = new Teacher("James McGallin", "Smith street 342", 49, "Assistant Professor");
        this.personArchive.addPerson(t1);
        t1 = new Teacher("Elisabeth Grey", "Main gate 23", 51, "Associate Professor");
        this.personArchive.addPerson(t1);
        t1 = new Teacher("Catheryn Loan", "Willow creek 87", 58, "Associate Professor");
        this.personArchive.addPerson(t1);
    }

    /**
     * Displays the menu tot he user, and waits for the users input. The user is
     * expected to input an integer between 1 and 4. If the user inputs anything
     * else, an InputMismatchException is thrown. The method returns the valid
     * input from the user.
     *
     * @return the menu number (between 1 and 4) provided by the user.
     * @throws InputMismatchException
     */
    private int showMenu() throws InputMismatchException {
        System.out.println("\n**** School Archive v1.0 ****\n");
        System.out.println("1. List all persons");
        System.out.println("2. List teachers");
        System.out.println("3. Add student");
        System.out.println("4. Exit\n");
        System.out.println("Please choose menu item (1-4): ");

        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > 4)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    /**
     * Lists all persons in the archive to the consol.
     */
    private void doListAllPersons() {
        System.out.println("\nList of all persons in the archive:");
        this.listAllContent(this.personArchive.getAllPersons());
    }

    /**
     * Lists all the teachers in the archive to the consol.
     */
    private void doListTeachers() {
        System.out.println("\nList of all teachers in the archive:");
        Collection<Person> tempList = this.personArchive.getPersonsOfClass(Teacher.class);
        this.listAllContent(tempList);
    }

    /**
     * Lists all the teachers in the archive to the consol. Alternative method
     */
    private void doListTeachers2() {
        System.out.println("\nList of all teachers in the archive:");
        ArrayList<Person> teachers = new ArrayList<>();
        Collection<Person> tempList = this.personArchive.getAllPersons();
        
        for (Person person : tempList)
        {
            if ( person instanceof Teacher)
            {
                teachers.add(person);
            }
        }   
        this.listAllContent(teachers);
    }

    /**
     * Asks the user for details about the student to add. If all info
     * provided by the user is valid, a new instance of Student is created
     * and added to the archive. If invalid info has been entered by the user
     * (for instance a text has been entered for age or student number), the
     * user is requested to re-enter the information.
     */
    private void doAddStudent() {
        String name = null;
        String address = null;
        int age = 0;
        int studentNumber = 0;

        boolean validInput = false; // Flag used to indicate that input is valid
        
        System.out.println("\nAdding a new studet:");

        while (!validInput) {
            try {
                Scanner reader = new Scanner(System.in);
                System.out.println("Please provide the following information about the student:");
                System.out.println("Name: ");
                name = reader.nextLine();
                System.out.println("Adress: ");
                address = reader.nextLine();
                System.out.println("Age: ");
                age = reader.nextInt();
                System.out.println("Student number: ");
                studentNumber = reader.nextInt();
                validInput = true;
            } catch (InputMismatchException ime) {
                System.out.println("Some of the information you provided was not valid.");
                System.out.println("Make sure you enter an integer value for age and student number.\n");
            }
        }
        
        Student newStudent = new Student(name, address, age, studentNumber);
        
        this.personArchive.addPerson(newStudent);
        System.out.println("A new student named " + name + " has been added to the archive.");
    }
}
