
import java.util.Map;

public class GoToBarToZipCommand implements Command {
    private Map<String, Command> map;

    public GoToBarToZipCommand(Map<String, Command> map) {
        this.map = map;
    }

    public Results invoke(String input) {
        String message="Please input zip code:";
        return new Results(message,map);
    }
}
