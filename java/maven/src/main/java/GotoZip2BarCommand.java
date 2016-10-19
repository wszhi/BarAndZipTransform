import java.util.HashMap;
import java.util.Map;

public class GotoZip2BarCommand implements Command {

    private Map<String, Command> newMapping;

    public GotoZip2BarCommand(Map<String, Command> newMapping) {
        this.newMapping = newMapping;
        this.newMapping = newMapping;
    }

    public Result invoke(String input) {
        return new Result("Please input zip code:", newMapping, false);
    }
}
