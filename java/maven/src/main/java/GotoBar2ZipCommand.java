import java.util.Map;

public class GotoBar2ZipCommand implements Command {
    private Map<String, Command> newMapping;

    public GotoBar2ZipCommand(Map<String, Command> newMapping) {
        this.newMapping = newMapping;
    }

    public Result invoke(String input) {
        return new Result("Please input bar code:", newMapping, false);
    }
}
