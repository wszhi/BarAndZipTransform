import java.util.Map;

public class GoToZipToBarCommand implements Command {
    private Map<String, Command> map;

    public GoToZipToBarCommand(Map<String, Command> map) {
        this.map = map;
    }

    public Results invoke(String input) {
        String message = "Please input bar code:";
        return new Results(message, map);
    }
}
