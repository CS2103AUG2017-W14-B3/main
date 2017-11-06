//@@author conantteo
package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BirthdayTest {

    @Test
    public void isValidBirthday() {
        // invalid birthday format
        assertFalse(Birthday.isValidBirthday("")); // empty string
        assertFalse(Birthday.isValidBirthday(" ")); // spaces only
        assertFalse(Birthday.isValidBirthday("02/03/190")); // less than 8 digits
        assertFalse(Birthday.isValidBirthday("02/03/19000")); // more than 8 digits
        assertFalse(Birthday.isValidBirthday("phone")); // non-numeric
        assertFalse(Birthday.isValidBirthday("9011p041")); // alphanumeric
        assertFalse(Birthday.isValidBirthday("02.03-1990")); //invalid characters between digits
        assertFalse(Birthday.isValidBirthday("02031990")); // exactly 8 digits without any forward slash
        assertFalse(Birthday.isValidBirthday("29/02/1900")); // invalid leap day

        // valid birthday format
        assertTrue(Birthday.isValidBirthday("29/02/2000")); // valid leap day
        assertTrue(Birthday.isValidBirthday("02/03/1990")); // DD/MM/YYYY format consists of 8 digits and 2 '/'
    }

    @Test
    public void isValidBirthdayMonth() {
        // invalid birthday month
        assertFalse(Birthday.isValidBirthdayMonth("011")); // more than 2 digits
        assertFalse(Birthday.isValidBirthdayMonth("1")); // less than 2 digits
        assertFalse(Birthday.isValidBirthdayMonth("13")); // exactly 2 digits but out of the range [01 to 12]

        // valid birthday month
        assertTrue(Birthday.isValidBirthdayMonth("01")); // exactly 2 digits between 01 to 12
    }
}
