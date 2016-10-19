import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HomeCommandTest {
    @Test
    public void should_return_home_result(){
        HomeCommand command = new HomeCommand();
        Result home = command.invoke("any");
        assertThat(home.getMessage(), is("--------\n" +
                "1. Translate Zipcode to Barcode\n" +
                "2. Translate Barcode to Zipcode\n" +
                "3. Exit\n" +
                "-------------" +
                "What is your command(1~3): "));
    }
}
