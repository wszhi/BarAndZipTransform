import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeCommandTest {
    @Test
    public void shouldReturnHomeMessageInResult() throws Exception {
        HomeCommand homeCommand = new HomeCommand();
        Results results = homeCommand.invoke("/");
        String expect = "1. Translate zip code to bar code\n" +
                "2. Translate bar code to zip code\n" +
                "3. Quit\n" +
                "Please input your choices(1~3)";
        assertEquals(expect,results.getMessage());

    }
}