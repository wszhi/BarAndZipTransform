import java.util.Map;

public class Router {
    private Map<String, Command> mapping;

    public void init(Map<String, Command> mapping) {
        this.mapping = mapping;
    }

    public String route(String input) {
        Command command = mapping.get(input);
        if(command == null){
            command = mapping.get("*");
            if( command == null){
                return "invalid command";
            }
        }
        Result result = command.invoke(input);
        String message = result.getMessage();
        return message;
    }
}
