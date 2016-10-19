import java.util.Map;

public class Result {
    public Result(String message) {
        this(message, null, false);
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Command> getNewMapping() {
        return newMapping;
    }

    public Boolean getReset() {
        return isReset;
    }

    private final String message;
    private final Map<String, Command> newMapping;
    private final Boolean isReset;

    public Result(String message, Map<String, Command> newMapping, Boolean isReset) {

        this.message = message;
        this.newMapping = newMapping;
        this.isReset = isReset;
    }
}
