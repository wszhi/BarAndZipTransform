import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RouterTest {

    @Test
    public void should_return_mapping_command_result(){

        Router router = new Router();
        Map mapping = new HashMap<String, Command>();
        Command command1 = mock(Command.class);
        when(command1.invoke(anyString())).thenReturn(new Result("x", null, false));
        mapping.put("1", command1);
        router.init(mapping);

        String result = router.route("1");
        assertThat(result, is("x"));
    }

    @Test
    public void should_return_invalid_message_when_no_mapping_no_wild_mapping(){
        Router router = new Router();
        Map mapping = new HashMap<String, Command>();
        Command command1 = mock(Command.class);
        when(command1.invoke("any")).thenReturn(new Result("x", null, false));
        mapping.put("1", command1);
        router.init(mapping);

        String result = router.route("x");
        assertThat(result, is("invalid command"));
    }

    @Test
    public void should_return_mapping_command_result_when_wild_mapping(){
        Router router = new Router();
        Map mapping = new HashMap<String, Command>();
        Command command1 = mock(Command.class);
        when(command1.invoke(anyString())).thenReturn(new Result("x", null, false));
        mapping.put("*", command1);
        router.init(mapping);

        String result = router.route("sfjsldflsfjdl");
        assertThat(result, is("x"));
    }


}
