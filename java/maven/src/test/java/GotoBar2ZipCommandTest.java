import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class GotoBar2ZipCommandTest {
    @Test
    public void should_print_tips(){
        Map<String, Command> newMapping = new HashMap<String, Command>();
        newMapping.put("*", mock(TranslateBar2ZipCommand.class));
        Command command = new GotoBar2ZipCommand(newMapping);

        Result result = command.invoke("any");
        assertThat(result.getMessage(), is("Please input bar code:"));
    }

    @Test
    public void should_return_new_mapping(){
        Map<String, Command> newMapping = new HashMap<String, Command>();
        newMapping.put("*", mock(TranslateBar2ZipCommand.class));
        Command command = new GotoZip2BarCommand(newMapping);

        Result result = command.invoke("any");
        assertThat(result.getNewMapping().containsKey("*"), is(true));
        assertThat(result.getNewMapping().get("*"), is(TranslateBar2ZipCommand.class));

    }
}
