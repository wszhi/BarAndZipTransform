import java.util.Map;


public class Results {
    private String message;
    private Map<String, Command> map;
    private boolean reset;

    public Results(String message, Map<String, Command> map) {
        this.message = message;
        this.map = map;
    }

    public Results(String message, boolean isReset) {
        this.message = message;
        this.map = null;
        this.reset = isReset;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Command> getMap() {
        return map;
    }

    public Results(String input) {
        this.message = input;
        map = null;

    }

    public boolean isReset() {
        return reset;
    }
}
