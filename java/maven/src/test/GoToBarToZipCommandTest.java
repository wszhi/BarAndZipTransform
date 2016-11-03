import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class GoToBarToZipCommandTest {
    @Test
    public void shouldReturnResultWithTipsAndNewMap() throws Exception {
        Map<String, Command> map = new HashMap<String, Command>();
        HomeCommand homeCommand = mock(HomeCommand.class);
        map.put("*",homeCommand);
        GoToBarToZipCommand goToBarToZipCommand = new GoToBarToZipCommand(map);

        Results result = goToBarToZipCommand.invoke("1");

        String message = "Please input zip code:";
        assertEquals(message, result.getMessage());
        assertNotNull(result.getMap());
        //缺乏map测试
        assertTrue(result.getMap().containsKey("*"));
        assertThat((HomeCommand) result.getMap().get("*"),is(homeCommand));
    }
}
