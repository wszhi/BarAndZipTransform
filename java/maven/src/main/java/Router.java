import java.util.Map;

public class Router {
    private Map<String, Command> map;

    public Router(Map<String, Command> map) {
        this.map = map;

    }

    public String route(String input) {
        Command command = this.map.get(input);
        if (command == null){
            command = this.map.get("*");
            if(command == null){
                return "invalid input";
            }
        }
        Results results= command.invoke(input);
        return results.getMessage();
    }
}
