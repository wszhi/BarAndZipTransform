import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TranslateBar2ZipCommandTest {
    @Test
    public void should_translate_and_return_to_home(){
        TranslateBar2ZipService service = mock(TranslateBar2ZipService.class);
        when(service.translate("right")).thenReturn(new CoreResult("good job", false));

        Command command = new TranslateBar2ZipCommand(service);
        Result result = command.invoke("right");

        assertThat(result.getReset(), is(true));
        assertThat(result.getMessage(), is("good job\n"+
                "--------\n" +
                "1. Translate Zipcode to Barcode\n" +
                "2. Translate Barcode to Zipcode\n" +
                "3. Exit\n" +
                "-------------" +
                "What is your command(1~3): "));
    }


    @Test
    public void should_give_tips_and_do_nothing(){
        TranslateBar2ZipService service = mock(TranslateBar2ZipService.class);
        when(service.translate("wrong")).thenReturn(new CoreResult("bad job", true));

        Command command = new TranslateBar2ZipCommand(service);
        Result result = command.invoke("wrong");

        assertThat(result.getReset(), is(false));
        assertThat(result.getMessage(), is("Please input valid bar code:"));
    }
}
