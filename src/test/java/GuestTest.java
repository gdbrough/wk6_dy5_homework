import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    private Guest guest;

    @Before
    public void before(){
        guest = new Guest("First Guest");
    }

    @Test
    public void canGetName(){
        assertEquals("First Guest", guest.getName());
    }

    @Test
    public void canSetName(){
        guest.setName("Set Test");
        assertEquals("Set Test", guest.getName());
    }

}
