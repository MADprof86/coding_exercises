/*Testing the new options
For now it has to be ok as a header
KZ
 */
package pl.coderslab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Person {
    private static final Logger logger = LogManager.getLogger(Person.class);
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        logger.info("Getting first name");
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        logger.info("Setting second name");
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getInitials() {
        return (this.firstName.charAt(0) + "." + this.lastName.charAt(0) + ".");
    }

}
