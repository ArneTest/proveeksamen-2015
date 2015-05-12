
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Represents the archive of all people in a university/school.
 * The archive provides some simple functionality like adding a person,
 * removing a person etc.
 * 
 * @author asty
 * @version 2015-05-02
 */
public class PersonArchive {
    private ArrayList<Person> archive;
    
    /**
     * Creates an object of PersonArchive
     */
    public PersonArchive()
    {
        this.archive = new ArrayList<>();
    }
    
    /**
     * Add a person to the archive
     * 
     * @param person the person to add to the archive
     */
    public void addPerson( Person person )
    {
        this.archive.add(person);
    }
    
    /**
     * Returns all the persons in the archive.
     * 
     * @return all the persons in the archive
     */
    public Collection<Person> getAllPersons()
    {
        return this.archive;
    }
    
    /**
     * Search the archive for a person with a name matching the
     * name provided by the parameter.
     * If no match is found, null is returned.
     * 
     * @param name the name to search for
     * @return the person matching the name. If no match, null is returned
     */
    public Person findPersonByName( String name )
    {
        Person foundPerson = null;
        Iterator<Person> it = this.archive.iterator();
        while ( (foundPerson == null) && (it.hasNext()) )
        {
            Person tempPerson = it.next();
            if ( tempPerson.getName().equals(name))
            {
                foundPerson = tempPerson;
            }
        }
        return foundPerson;
    }
    
    /**
     * Returns all objects in the archive matching the class of the
     * parameter.
     * 
     * @param aClass The class of the objects to extract from the archive
     * @return A collection of objects of the type given by the parameter aClass
     */
    public Collection<Person> getPersonsOfClass( Class<?> aClass )
    {
        ArrayList<Person> resultCollection;
        resultCollection = new ArrayList<>();
        
        for (Person tmpPerson : this.archive)
        {
            if ( tmpPerson.getClass() == aClass)
            {
                resultCollection.add(tmpPerson);
            }
        }
        return resultCollection;
    }
    
}
