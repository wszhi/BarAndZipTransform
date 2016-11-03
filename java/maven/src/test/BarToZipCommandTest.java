import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BarToZipCommandTest {
    @Test
    public void shouldReturnCodeWithResetFlag() throws Exception {
        BarToZipService barToZipService = mock(BarToZipService.class);
        BarToZipCommand barToZipCommand = new BarToZipCommand(barToZipService);
        String input="|:|::|";
        ResultForCode resultForCode = new ResultForCode();
        resultForCode.setValue("45");
        resultForCode.setValid(true);
        when(barToZipService.translate(input)).thenReturn(resultForCode);

        Results results = barToZipCommand.invoke(input);

        assertEquals("45", results.getMessage());
        assertTrue(results.isReset());

    }

    @Test
    public void shouldReturnErrorMessageWhenInputInvalid() throws Exception {
        BarToZipService barToZipService = mock(BarToZipService.class);
        BarToZipCommand barToZipCommand = new BarToZipCommand(barToZipService);
        String input="aa";
        ResultForCode resultForCode = new ResultForCode();
        resultForCode.setValid(false);
        when(barToZipService.translate(input)).thenReturn(resultForCode);

        Results results = barToZipCommand.invoke(input);

        assertEquals("invalid input", results.getMessage());
        assertFalse(results.isReset());

    }
}
