import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ZipToBarCommandTest {
    @Test
    public void shouldReturnBarCodeAndResetFlagWhenInputValid() throws Exception {
        ZipToBarService zipToBarService = mock(ZipToBarService.class);
        ZipToBarCommand zipToBarCommand = new ZipToBarCommand(zipToBarService);
        String input="45";
        ResultForCode resultForCode = new ResultForCode();
        resultForCode.setValue("|:|::|");
        resultForCode.setValid(true);
        when(zipToBarService.translate(input)).thenReturn(resultForCode);

        Results results=zipToBarCommand.invoke(input);

        assertEquals("|:|::|",results.getMessage());
        assertTrue(results.isReset());
    }
    @Test
    public void shouldReturnErrorMessageWhenInputInvalid() throws Exception {
        ZipToBarService zipToBarService = mock(ZipToBarService.class);
        ZipToBarCommand zipToBarCommand = new ZipToBarCommand(zipToBarService);
        String input="aa";
        ResultForCode resultForCode = new ResultForCode();
        resultForCode.setValid(false);
        when(zipToBarService.translate(input)).thenReturn(resultForCode);

        Results results = zipToBarCommand.invoke(input);

        assertEquals("invalid input", results.getMessage());
        assertFalse(results.isReset());

    }
}
