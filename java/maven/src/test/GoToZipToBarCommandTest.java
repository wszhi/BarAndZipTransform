import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class GoToZipToBarCommandTest {
    @Test
    public void shouldReturnTipsAndNewMapWhenCallInvoke() throws Exception {
        Map<String, Command> map = new HashMap<String, Command>();
        HomeCommand homeCommand = mock(HomeCommand.class);
        map.put("*", homeCommand);
        GoToZipToBarCommand goToZipToBarCommand = new GoToZipToBarCommand(map);

        Results result = goToZipToBarCommand.invoke("2");

        String message = "Please input bar code:";
        assertEquals(message, result.getMessage());
        assertNotNull(result.getMap());
        assertTrue(result.getMap().containsKey("*"));
        assertThat((HomeCommand) result.getMap().get("*"), is(homeCommand));

    }
}
