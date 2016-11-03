import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RouterTest {
    @Test
    public void shouldReturnCorrectMessageWhenTheCommandInMap() throws Exception {
        Map<String,Command> map = new HashMap<String, Command>();
        Command command = mock(Command.class);
        map.put("/",command);
        Results result = new Results("home");
        when(command.invoke(anyString())).thenReturn(result);
        Router router = new Router(map);


        String resultMessage= router.route("/");
        assertEquals("home",resultMessage);


    }

    @Test
    public void shouldReturnCurrentWhenThereIsAnyCommandInMap() throws Exception {
        Map<String,Command> map = new HashMap<String, Command>();
        Command command = mock(Command.class);
        map.put("*",command);
        Results result = new Results("current");
        when(command.invoke(anyString())).thenReturn(result);
        Router router = new Router(map);


        String resultMessage= router.route("aa");
        assertEquals("current",resultMessage);

    }

    @Test
    public void shouldReturnErrorMessageWhenInputIsInvalid() throws Exception {
        Map<String,Command> map = new HashMap<String, Command>();
        Command command = mock(Command.class);
        map.put("/",command);
        Results result = new Results("home");
        when(command.invoke(anyString())).thenReturn(result);
        Router router = new Router(map);


        String resultMessage= router.route("aa");
        assertEquals("invalid input",resultMessage);

    }
}